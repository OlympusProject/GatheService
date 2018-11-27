package com.gathe.community.service.impl;

import com.gathe.community.domain.User;
import com.gathe.community.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImplStub implements UserService {

    private static List<User> stub;

    static {
        stub = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setName("Daniel");
        user.setEmail("daniesnata@gmail.com");
        user.setPhoto("daniel-photo.jpg");
        stub.add(user);
        user = new User();
        user.setId(2L);
        user.setName("Eddo");
        user.setEmail("eddotjong.eddotjong@gmail.com");
        user.setPhoto("eddo-tjong-photo.jpg");
        stub.add(user);
    }

    @Override
    public User find(Long id) {
        for (User user : stub) {
            if (user.getId().equals(id)) return user;
        }
        return null;
    }

    @Override
    public Collection<User> find(Collection<Long> ids) {
        return null;
    }
}
