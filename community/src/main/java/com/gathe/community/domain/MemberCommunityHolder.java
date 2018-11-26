package com.gathe.community.domain;

public class MemberCommunityHolder {

    // -- members ----------------------------------------------------------------------------------
    private Community inCommunity;
    private Status status;


    public MemberCommunityHolder(Community inCommunity) {
        this.inCommunity = inCommunity;
        this.status = Status.MEMBER;
    }

    // -- getters & setters -------------------------------------------------------------------------
    public Community getInCommunity() {
        return inCommunity;
    }

    public void setInCommunity(Community inCommunity) {
        this.inCommunity = inCommunity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
