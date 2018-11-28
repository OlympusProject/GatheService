package com.gathe.user.services.impl;

import com.gathe.user.domain.User;
import com.gathe.user.repository.UserRepo;
import com.gathe.user.services.UserSevice;
import java.util.List;

public class UserServiceImpl implements UserSevice {

    private final UserRepo userRepo;

    public UserServiceImpl(final UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public boolean create(User user){
        return true;
    }

    @Override
    public boolean delete(User user) {
        return true;
    }

    @Override
    public User find(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> find(int page, int size){
        return userRepo.findAll();
    }

}
