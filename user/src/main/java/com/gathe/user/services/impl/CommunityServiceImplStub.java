package com.gathe.user.services.impl;

import com.gathe.user.domain.Community;
import com.gathe.user.services.CommunityService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommunityServiceImplStub implements CommunityService {

    private static List<Community> stub;
    private static List<String> interest;

    static {
        stub = new ArrayList<>();
        interest = new ArrayList<>();
        Community community = new Community();
        community.setId(1L);
        community.setName("Travel Addict");
        interest.add("Hiking");
        interest.add("Climbing");
        community.setInterest(interest);
        stub.add(community);
        interest = new ArrayList<>();
        community = new Community();
        community.setId(1L);
        community.setName("Dance and Dance");
        interest.add("Traditional");
        interest.add("Pop");
        community.setInterest(interest);
        stub.add(community);

    }

    @Override
    public Community find (Long id){
        for (Community community : stub){
            if (community.getId().equals(id)) return community;
        }
        return  null;
    }

    @Override
    public Collection<Community> find(Collection<Long>ids){
        return null;
    }


}
