package com.gathe.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private int userCount = 3;

    static {
        users.add(new User(1, "Teguh"));
        users.add(new User(2, "Teguh 1"));
        users.add(new User(3, "Teguh 2"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(userCount++);
        }
        users.add(user);
        return user;
    }

    /***
     *
     * @param id
     * @return user
     */

    public User findUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /***
     *
     * @param id
     * @return
     */

    public User deleteById(int id) {
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
