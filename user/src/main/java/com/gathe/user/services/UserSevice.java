package com.gathe.user.services;

import com.gathe.user.domain.User;

import java.util.Collection;
import java.util.List;

public interface UserSevice {

    boolean create(User user);

    boolean delete(User user);

    User find(Long id);

    List<User> find(int page, int size);
}
