package com.gathe.community.domain;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    // -- members ---------------------------------------------------------------------------------- //
    private List<MemberCommunityHolder> communityHolders = new ArrayList<>();
    private OffsetDateTime joinSince;





    // -- constructors ----------------------------------------------------------------------------- //
    public Member() {

    }

    public Member(User user) {
        this.id = user.id;
        this.email = user.email;
        this.name = user.name;
    }

    public Member joinCommunity(Community community) {
        MemberCommunityHolder holder = new MemberCommunityHolder(this, community);
        this.communityHolders.add(holder);
        return this;
    }





    // -- others ------------------------------------------------------------------------------------ //
    public boolean addCommunityHolder(MemberCommunityHolder holder) {
        return this.communityHolders.add(holder);
    }

    public void setJoiningTime() {
        this.joinSince = OffsetDateTime.now();
    }



    // -- getters & setters ------------------------------------------------------------------------- //
    public List<MemberCommunityHolder> getCommunityHolders() {
        return communityHolders;
    }

    public void setCommunityHolders(List<MemberCommunityHolder> communityHolders) {
        this.communityHolders = communityHolders;
    }

    public OffsetDateTime getJoinSince() {
        return joinSince;
    }

    public void setJoinSince(OffsetDateTime joinSince) {
        this.joinSince = joinSince;
    }
}
