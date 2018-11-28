package com.gathe.user.repository;

import com.gathe.user.domain.User;

import java.util.List;

public interface UserRepo {

    List<User> findAll();

    User save(User user);

    User findById(Long id);

    User deleteById(Long id);
}