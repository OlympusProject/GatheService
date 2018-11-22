package com.gathe.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private int userCount = 3;

    /***
     * add dummy data
     */
    static {
        users.add(new User(1, "teguh1@gmail.com", "Teguh", "Satu"));
        users.add(new User(2, "teguh2@gmail.com", "Teguh", "Dua"));
        users.add(new User(3, "teguh3@gmail.com", "Teguh", "Tiga"));

    }

    /***
     * function to retrieve all user
     * @return
     */

    public List<User> findAll() {
        return users;
    }

    /***
     * add new user
     * @param user
     * @return
     */

    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(userCount++);
        }
        users.add(user);
        return user;
    }

    /***
     * function to find a single user
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
     * function to delete user
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
