package com.gathe.auth.util.mapper;

import com.gathe.auth.domain.oauth.client.OAuthClient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OAuthClientRowMapper implements RowMapper<OAuthClient> {

    @Override
    public OAuthClient mapRow(ResultSet resultSet, int i) throws SQLException {

        OAuthClient client =  new OAuthClient();

        client.setId(resultSet.getLong("ID"));
        client.setClientId(resultSet.getString("CID"));
        client.setClientSecret(resultSet.getString("CSECRET"));
        client.setName(resultSet.getString("NAME"));
        client.setEmail(resultSet.getString("EMAIL"));
        client.setEnabled(resultSet.getBoolean("ENABLED"));
        client.setAuthority(resultSet.getString("AUTHORITY"));

        return client;
    }
}
