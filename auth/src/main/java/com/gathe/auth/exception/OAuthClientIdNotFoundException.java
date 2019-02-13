package com.gathe.auth.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class OAuthClientIdNotFoundException extends UsernameNotFoundException {


    public OAuthClientIdNotFoundException(String msg) {
        super(msg);
    }

    public OAuthClientIdNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
