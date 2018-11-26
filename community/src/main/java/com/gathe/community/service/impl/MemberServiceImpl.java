package com.gathe.community.service.impl;

import com.gathe.community.domain.Community;
import com.gathe.community.domain.User;
import com.gathe.community.service.MemberService;

public class MemberServiceImpl implements MemberService {

    @Override
    public boolean join(Community community, User user) {

        if (community != null && user != null) {
            return true;
        }

        return false;
    }

    @Override
    public boolean register(Community community, User user) {

        if (community != null && user != null) {
            return true;
        }

        return false;
    }
}
