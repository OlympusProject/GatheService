package com.gathe.auth;

import com.gathe.auth.config.OAuthDataConfig;
import com.gathe.auth.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[] {AuthApplication.class, WebSecurityConfig.class, OAuthDataConfig.class}, args);
//		SpringApplication.run(AuthApplication.class, args);
	}

}

