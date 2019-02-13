package com.gathe.auth.security;

import com.gathe.auth.domain.oauth.client.OAuthClient;
import com.gathe.auth.exception.OAuthClientIdNotFoundException;
import com.gathe.auth.service.OAuthClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class OAuthClientAuthenticationProvider implements AuthenticationProvider {


    // ~ Instance fields
    // =================================================================================================================
    private PasswordEncoder passwordEncoder;
    @Autowired private OAuthClientDetailsService userDetailsService;

    /**
     * This variable will determine if true, client not found exception will be shown on error message
     * if false, bad credentials will be shown instead
     */
    private boolean hideClientNotFound = true;

    /**
     * The password used to perform
     * {@link PasswordEncoder#matches(CharSequence, String)} on when the user is
     * not found to avoid SEC-2056. This is necessary, because some
     * {@link PasswordEncoder} implementations will short circuit if the password is not
     * in a valid format.
     */
    private volatile String userNotFoundEncodedPassword;



    // ~ Constructors
    // =================================================================================================================
    public OAuthClientAuthenticationProvider() {
        this.setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }



    // ~ Methods
    // =================================================================================================================
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        OAuthClient client = null;
        final String clientId = authentication.getPrincipal() == null ? "NONE_PROVIDED" : authentication.getName();

        try {
            client = this.retrieveUser(clientId, (UsernamePasswordAuthenticationToken) authentication);
        }
        catch (OAuthClientIdNotFoundException ex) {
            if (hideClientNotFound)
                throw new BadCredentialsException("Authentication failed: Bad credentials");

            throw ex;
        }

        if (authentication.getCredentials() == null)
            throw new BadCredentialsException("Authentication failed: No credential provided");
        else {
            String presentedPassword = authentication.getCredentials().toString();

            // this implementation should be removed. Use encoded password to compare instead >>>>>>>>>>>>>>>>>>>>>>>>>>
            if (!presentedPassword.equals(client.getClientSecret()))
                throw new BadCredentialsException("Authentication failed: Bad credentials");
            // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        }

        return new UsernamePasswordAuthenticationToken(client.getId(), client.getClientSecret(), client.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    /**
     * This method going to retrieve the <code>OAuthClient</code> by the given <code>clientId</code>.
     * @param clientId
     * @param authentication
     * @return
     * @throws OAuthClientIdNotFoundException when the <code>email</code> is not found
     * @throws InternalAuthenticationServiceException in case of the <code>userDetailsService</code> isn't implemented, or any other exception which will be wrapped by <code>InternalAuthenticationServiceException</code>
     */
    protected final OAuthClient retrieveUser(String clientId, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        this.prepareTimingAttackProtection();

        try {
            OAuthClient loadedClient = this.userDetailsService.loadUserByUsername(clientId);
            // "ByUsername" it's a default method name which should be overridden according to Spring framework
            // in this case, the value containing clientId is used
            if (loadedClient == null) {
                throw new InternalAuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
            }
            return loadedClient;
        }
        catch (OAuthClientIdNotFoundException ex) {
            this.mitigateAgainstTimingAttack(authentication);
            throw ex;
        }
        catch (InternalAuthenticationServiceException ex) {
            throw ex;
        }
        catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * This method serves to prepare userNotFoundEncodedPassword with dummy value
     * refer to SEC-2056
     */
    private void prepareTimingAttackProtection() {
        if (this.userNotFoundEncodedPassword == null) {
            this.userNotFoundEncodedPassword = this.passwordEncoder.encode("gathe_custom_password_to_avoid_timing_attack");
        }
    }

    /**
     * This method does the comparison of password, when the authentication doesn't find the valid email
     * @param authentication token that give wrong email (email not found)
     * refer to SEC-2056
     */
    private void mitigateAgainstTimingAttack(UsernamePasswordAuthenticationToken authentication) {
        if (authentication.getCredentials() != null) {
            String presentedPassword = authentication.getCredentials().toString();
            this.passwordEncoder.matches(presentedPassword, this.userNotFoundEncodedPassword);
        }
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userNotFoundEncodedPassword = null;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setUserDetailsService(OAuthClientDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    protected OAuthClientDetailsService getUserDetailsService() {
        return this.userDetailsService;
    }

    public boolean isClientNotFoundHidden() {
        return this.hideClientNotFound;
    }

    public void setHideClientNotFound(boolean value) {
        this.hideClientNotFound = value;
    }
}
