package com.gathe.auth.domain.oauth.client;

import com.gathe.auth.util.validator.annotation.ConfirmPassword;
import com.gathe.auth.util.validator.annotation.UniqueClientId;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@ConfirmPassword(password = "clientSecret", confirmPassword = "clientSecretConfirmation", message = "Client Secret doesn't match")
public class RegistrantClient implements Client {


    // ~ Instances
    // =================================================================================================================
    @NotEmpty @UniqueClientId
    private String clientId;

    @NotEmpty
    private String clientSecret;

    @NotEmpty
    private String clientSecretConfirmation;

    @NotEmpty
    private String name;

    @Nullable @Email
    private String email;





    // ~ Methods
    // =================================================================================================================
    public boolean isClientSecretConfirmed() {
        boolean result = clientSecret.equals(clientSecretConfirmation);
        return result;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientSecretConfirmation() {
        return clientSecretConfirmation;
    }

    public void setClientSecretConfirmation(String clientSecretConfirmation) {
        this.clientSecretConfirmation = clientSecretConfirmation;
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

    @Override
    public String getPassword() {
        return clientSecret;
    }

    @Override
    public String getConfirmPassword() {
        return clientSecretConfirmation;
    }
}
