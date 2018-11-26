package com.gathe.community.service.impl;

import com.gathe.community.domain.Community;
import com.gathe.community.domain.User;
import com.gathe.community.repository.CommunityRepo;
import com.gathe.community.service.CommunityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepo communityRepo;

    public CommunityServiceImpl(final CommunityRepo communityRepo) {
        this.communityRepo = communityRepo;
    }

    @Override
    public boolean create(Community community, User owner) {
        return false;
    }

    @Override
    public boolean delete(Community community) {
        return false;
    }

    @Override
    public Community find(Long id) {
        return communityRepo.find(id);
    }

    @Override
    public List<Community> find(int page, int size) {
        return null;
    }
}
