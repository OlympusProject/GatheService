package com.gathe.user.repository.impl;

import com.gathe.user.domain.User;
import com.gathe.user.repository.UserRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserRepoStub implements UserRepo {
    private static List<User> users = new ArrayList<>();
    private int userCount = 3;

    /***
     * add dummy data
     */
    static {
        users.add(new User(Long.parseLong(String.valueOf(1)), "teguh1@gmail.com", "Teguh", "Satu"));
        users.add(new User(Long.parseLong(String.valueOf(2)), "teguh2@gmail.com", "Teguh", "Dua"));
        users.add(new User(Long.parseLong(String.valueOf(3)), "teguh3@gmail.com", "Teguh", "Tiga"));
    }

    /***
     * function to retrieve all user
     * @return
     */
    @Override
    public List<User> findAll() {
        return users;
    }

    /***
     * add new user
     * @param user
     * @return
     */
    @Override
    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(Long.parseLong(String.valueOf(userCount++)));
        }
        users.add(user);
        return user;
    }

    /***
     * function to find a single user
     * @param id
     * @return user
     */

    @Override
    public User findById(Long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /***
     * function to delete user
     * @param id
     * @return
     */
@Override
    public User deleteById(Long id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
