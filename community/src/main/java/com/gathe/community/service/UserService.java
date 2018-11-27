package com.gathe.community.service;

import com.gathe.community.domain.User;

import java.util.Collection;

public interface UserService {

    User find(Long id);

    Collection<User> find(Collection<Long> ids);
}
