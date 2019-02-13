package com.gathe.auth.repository.impl;

import com.gathe.auth.domain.oauth.client.OAuthClient;
import com.gathe.auth.repository.OAuthClientRepository;
import com.gathe.auth.util.mapper.OAuthClientRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class OAuthClientRepositoryImpl implements OAuthClientRepository {

    private static final String TABLE_NAME = "CLIENTS";

    // TODO: 2019-02-13 timestamp for creation should be managed by DB. for now, the impl is using dummy_timestamp
    private static final String DUMMY_TIMESTAMP = "2019-01-09T09:29:30+00:00";


    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OAuthClientRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public OAuthClient findClient(String CID) throws DataAccessException {

        SqlParameterSource namedParam = new MapSqlParameterSource().addValue("cid", CID);
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE CID = :cid";

        OAuthClient result = null;
        try {
            result = jdbcTemplate.queryForObject(sql, namedParam, new OAuthClientRowMapper());
        }
        catch (DataAccessException ex) {
            throw ex;
        }

        if (result == null)
            throw new DataRetrievalFailureException("Failed to retrieve data with client name: " + CID);

        return result;
    }

    @Override
    public boolean clientExists(String clientId) {

        SqlParameterSource namedParam = new MapSqlParameterSource().addValue("cid", clientId);
        String sql = "SELECT count(*) FROM " + TABLE_NAME + " WHERE CID = :cid";

        Boolean result = jdbcTemplate.queryForObject(sql, namedParam, Boolean.class);
        if (result == null) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean save(OAuthClient client) throws DataAccessException {

        String cid = client.getClientId();

        SqlParameterSource namedParam = new MapSqlParameterSource()
                                        .addValue("cid", client.getClientId())
                                        .addValue("csecret", client.getClientSecret())
                                        .addValue("name", client.getName())
                                        .addValue("email", client.getEmail())
                                        .addValue("authority", client.getAuthority())
                                        .addValue("enabled", client.isEnabled());

        String sql = "INSERT INTO " + TABLE_NAME + " (cid, name, email, csecret, authority, enabled, created) values (:cid, :name, :email, :csecret, :authority, :enabled, '" + DUMMY_TIMESTAMP + "')";

        int rowsAffected = 0;
        try {
            rowsAffected = jdbcTemplate.update(sql, namedParam);
        }
        catch (DataAccessException ex) {
            throw ex;
        }

        if (rowsAffected == 1) {
            client = findClient(cid);
            return true;
        }

        return false;
    }
}
