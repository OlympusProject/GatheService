package com.gathe.community.service;

import com.gathe.community.domain.Community;
import com.gathe.community.domain.User;

public interface MemberService {

    /**
     *
     * @param community
     * @param user
     * @return
     */
    boolean join (Community community, User user);

    boolean register (Community community, User user);
}
