package com.gathe.auth.service;

import com.gathe.auth.domain.oauth.client.Client;
import com.gathe.auth.domain.oauth.client.OAuthClient;
import com.gathe.auth.domain.oauth.client.RegistrantClient;
import com.gathe.auth.exception.OAuthClientIdNotFoundException;
import com.gathe.auth.repository.OAuthClientRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OAuthClientDetailsService implements UserDetailsService {

    // ~ Instance fields
    // =================================================================================================================
    private final OAuthClientRepository repository;
    private final PasswordEncoder passwordEncoder;



    // ~ Constructors
    // =================================================================================================================
    public OAuthClientDetailsService(OAuthClientRepository repository) {
        this.repository = repository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }



    // ~ Methods
    // =================================================================================================================
    @Override
    public OAuthClient loadUserByUsername(String clientId) throws UsernameNotFoundException {

        OAuthClient client = null;
        try {
            client = repository.findClient(clientId);
        } catch (DataRetrievalFailureException ex) {
            throw new OAuthClientIdNotFoundException("Client id "+ clientId + " not found", ex);
        }

        return client;
    }

    public boolean clientIdExists(String clientId) {
        boolean result = repository.clientExists(clientId);
        return result;
    }


    public boolean registerAccount(Client origin) {

        boolean result = false;

        if (origin instanceof RegistrantClient) {
            RegistrantClient registrant = (RegistrantClient) origin;
            OAuthClient client = new OAuthClient(registrant);
            client.setAuthorityWithDefault();
            client.setEnabled(true);
            encodeSecret(client, registrant);

            try {
                result = repository.save(client);
            } catch (DataAccessException ex) {
            }

            if (result) {
                origin = client;
            }
        }

        return result;
    }



    private boolean encodeSecret(OAuthClient client, RegistrantClient registrant) {
        client.setClientSecret(null);
        final String encodedSecret = passwordEncoder.encode(registrant.getClientSecret());
        if (encodedSecret != null && !encodedSecret.isEmpty()) {
            client.setClientSecret(encodedSecret);
        }
        return client.getClientSecret() != null;
    }
}
