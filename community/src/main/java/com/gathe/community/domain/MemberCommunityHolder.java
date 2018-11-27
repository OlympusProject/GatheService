package com.gathe.community.domain;

public class MemberCommunityHolder {

    // -- members ----------------------------------------------------------------------------------
    private User user;
    private Community inCommunity;
    private Status status;

    public MemberCommunityHolder() {

    }

    public MemberCommunityHolder(User user, Community inCommunity) {
        this.user = user;
        this.inCommunity = inCommunity;
        this.status = Status.JOINING;
    }



    public Member getMember() {
        if (isMember()) return (Member) user;
        else return null;
    }

    public boolean isMember() {
        return status != Status.JOINING;
    }


    // -- getters & setters -------------------------------------------------------------------------
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
