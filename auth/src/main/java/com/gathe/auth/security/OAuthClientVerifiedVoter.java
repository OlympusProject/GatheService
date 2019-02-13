package com.gathe.auth.security;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Daniel Saldinata
 */
public class OAuthClientVerifiedVoter implements AccessDecisionVoter<Object> {


    // ~ Instance fields
    // =================================================================================================================
    private String PREFIX = "CLIENT_";
    private String INTERNAL = PREFIX + "INTERNAL";
    private String EXTERNAL_REGISTERED = PREFIX + "EXTERNAL_REGISTERED";



    // ~ Methods
    // =================================================================================================================
    @Override
    public boolean supports(ConfigAttribute configAttribute) {

        if ((configAttribute.getAttribute() != null) &&
                (configAttribute.getAttribute().startsWith(PREFIX))) {
            return true;
        }
        else
            return false;

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }



    @Override
    public int vote(Authentication authentication, Object o, Collection<ConfigAttribute> collection) {

        if (authentication ==  null)
            return ACCESS_DENIED;

        int result = ACCESS_ABSTAIN;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (ConfigAttribute attribute : collection) {
            if (this.supports(attribute)) {
                result = ACCESS_DENIED;
                for (GrantedAuthority authority : authorities) {
                    if (attribute.getAttribute().equals(authority.getAuthority())) {
                        return ACCESS_GRANTED;
                    }
                }
            }
        }

        return result;
    }
}
