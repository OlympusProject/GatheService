package com.gathe.auth.domain.oauth.client;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class OAuthClient implements UserDetails, Client {


    // ~ Instance fields
    // =================================================================================================================
    public static final String CLIENT_INTERNAL = "CLIENT_INTERNAL";

    private Long id;
    private String clientId;
    private String clientSecret;
    private String name;
    private String email;
    private String authority;
    private Boolean enabled;




    // ~ Constructors
    // =================================================================================================================
    public OAuthClient() {

    }

    public OAuthClient(String clientId, String clientSecret, String name) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.name = name;
    }

    /**
     * This constructor will create the Persistent Client object from Registrant object.
     * It will not pass the raw password, instead it should be hashed and set to this object by another method.
     * @param registrant client object created when filling the registry form
     */
    public OAuthClient(RegistrantClient registrant) {
        this.clientId = registrant.getClientId();
        this.name = registrant.getName();
        this.email = registrant.getEmail();
    }



    // ~ Methods
    // =================================================================================================================

    public void setAuthorityWithDefault() {
        this.authority = CLIENT_INTERNAL;
    }

    public String getClientId() {
        return getUsername();
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientSecret() {
        return getPassword();
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(authority));
    }

    @Override
    public String getPassword() {
        return clientSecret;
    }

    @Override
    public String getConfirmPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return clientId;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


}
