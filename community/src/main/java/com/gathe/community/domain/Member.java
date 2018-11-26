package com.gathe.community.domain;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    private List<MemberCommunityHolder> communityHolders = new ArrayList<>();

    public Member() {

    }

    public Member(User user) {
        this.id = user.id;
        this.email = user.email;
        this.name = user.name;
    }

    public Member joinCommunity(Community community) {
        MemberCommunityHolder holder = new MemberCommunityHolder(community);
        this.communityHolders.add(holder);
        return this;
    }
}
