package com.gathe.community.service;

import com.gathe.community.domain.Community;
import com.gathe.community.domain.User;

import java.util.List;

public interface CommunityService {

    boolean create(Community community, User owner);

    boolean delete(Community community);

    Community find(Long id);

    List<Community> findAll();

    List<Community> find(int page, int size);
}
