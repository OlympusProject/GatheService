package com.gathe.auth.service;

import com.gathe.auth.AuthApplication;
import com.gathe.auth.domain.oauth.client.OAuthClient;
import com.gathe.auth.exception.OAuthClientIdNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {AuthApplication.class})
public class OAuthClientDetailsServiceTest {

    @Autowired
    private OAuthClientDetailsService service;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    public void test_loadUserByUsername() throws Exception {

        final String clientId = "gathe.internal.admin.web";
        OAuthClient client = null;

        try {
            client = service.loadUserByUsername(clientId);
        }
        catch (OAuthClientIdNotFoundException ex) {
            System.out.println(ex);
        }

        assertNotNull(client);
        assertEquals(client.getClientId(), clientId);

    }

}