package com.gathe.user.services;

import com.gathe.user.domain.Community;

import java.util.Collection;

public interface CommunityService {
    Community find(Long id);
    Collection<Community>find(Collection<Long>ids);
}
