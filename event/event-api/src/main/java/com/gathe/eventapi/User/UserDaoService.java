package com.gathe.eventapi.User;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<UserProfile> UserProfiles = new ArrayList<>();
    private int userCount = 3;

    static {
        UserProfiles.add(new UserProfile(1, "Teguh"));
        UserProfiles.add(new UserProfile(2, "Teguh 1"));
        UserProfiles.add(new UserProfile(3, "Teguh 2"));
    }

    public List<UserProfile> findAll() {
        return UserProfiles;
    }

    public UserProfile save(UserProfile userProfile) {
        if (userProfile.getId() == null) {
            userProfile.setId(userCount++);
        }
        UserProfiles.add(userProfile);
        return userProfile;
    }

    public UserProfile findUser(int id) {
        for (UserProfile userProfile : UserProfiles) {
            if (userProfile.getId() == id) {
                return userProfile;
            }
        }
        return null;
    }
}
