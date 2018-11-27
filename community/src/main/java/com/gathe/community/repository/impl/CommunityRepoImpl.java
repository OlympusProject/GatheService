package com.gathe.community.repository.impl;

import com.gathe.community.domain.Community;
import com.gathe.community.domain.User;
import com.gathe.community.repository.CommunityRepo;
import com.gathe.community.service.UserService;
import com.gathe.community.service.impl.UserServiceImplStub;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommunityRepoImpl implements CommunityRepo {

    private static List<Community> stub;

    static {
        stub = new ArrayList<>();
        Community community;
        User user;
        community = new Community();
        community.setId(1L);
        community.setName("ONE OK POP");
        community.setAbout("We are absolute fans of ONE OK POP");
        community.setCreated(OffsetDateTime.now());
        stub.add(community);

        community = new Community();
        community.setId(2L);
        community.setName("Adventure");
        community.setAbout("Hiking, Diving, Exploring etc");
        UserService userService = new UserServiceImplStub();
        user = userService.find(1L);
        community.addJoiningUser(user);
        community.promoteMembership(user);
        user = userService.find(2L);
        community.addJoiningUser(user);
        community.promoteMembership(user);
        stub.add(community);
    }

    private long _nextId() {
        int last = stub.size()-1;
        Community temp = last < 0 ? null : stub.get(last);
        return temp == null ? 1 : temp.getId() +1;
    }

    @Override
    public Community save(Community community) {

        if (community != null) {
            community.setId(_nextId());
            community.setCreated(OffsetDateTime.now());
            stub.add(community);
        }

        return community;
    }


    @Override
    public Community find (Long id) {
        for (Community cur : stub) {
            if (cur.getId().equals(id)) return cur;
        }
        return null;
    }

    @Override
    public List<Community> find(List<String> interest) {
        return null;
    }
}
