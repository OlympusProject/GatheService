package com.gathe.auth.repository;

import com.gathe.auth.domain.oauth.client.OAuthClient;
import org.springframework.dao.DataAccessException;

public interface OAuthClientRepository  {

    OAuthClient findClient(String clientId);

    boolean clientExists(String clientId);

    boolean save(OAuthClient client) throws DataAccessException;
}
