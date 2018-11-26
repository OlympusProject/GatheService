package com.gathe.community.repository;

import com.gathe.community.domain.Community;

import java.util.List;

public interface CommunityRepo {

    Community save (Community community);

    Community find (Long id);

    List<Community> find (List<String> interest);

}
