package com.gathe.community.domain;

import java.time.OffsetDateTime;
import java.util.List;

public class Community implements Domain {

    // -- members ----------------------------------------------------------------------------------
    private Long id;
    private String name;
    private List<String> interests;
    private List<MemberCommunityHolder> members;
    private List<MemberCommunityHolder> joiningUsers;
    private String about;
    private OffsetDateTime created;
    private OffsetDateTime deleted;
    private OffsetDateTime modified;





    public boolean addJoiningUser(User user){
        if (user != null) {
            MemberCommunityHolder holder = new MemberCommunityHolder(user, this);
            return this.joiningUsers.add(holder);
        }
        return false;
    }

    public boolean promoteMembership(User user) {
        boolean result = false;
        MemberCommunityHolder holder = null;
        if (user != null) {
            for (MemberCommunityHolder curHolder : this.joiningUsers) {
                User curUser = curHolder.getUser();
                if (curUser.equals(user)) {
                    Member member = new Member(curUser);
                    member.addCommunityHolder(curHolder);
                    member.setJoiningTime();
                    curHolder.setUser(member);
                    curHolder.setStatus(Status.MEMBER);
                    result = this.members.add(curHolder);
                    holder = curHolder;
                    break;
                }
            }
            result = result && this.joiningUsers.remove(holder);
        }
        return result;
    }

    public int getNbOfMembers() {
        if (this.members != null)
            return this.members.size();
        else
            return 0;
    }






    // -- getters & setters -------------------------------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<MemberCommunityHolder> getMembers() {
        return members;
    }

    public void setMembers(List<MemberCommunityHolder> members) {
        this.members = members;
    }

    public List<MemberCommunityHolder> getJoiningUsers() {
        return joiningUsers;
    }

    public void setJoiningUsers(List<MemberCommunityHolder> joiningUsers) {
        this.joiningUsers = joiningUsers;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public OffsetDateTime getDeleted() {
        return deleted;
    }

    public void setDeleted(OffsetDateTime deleted) {
        this.deleted = deleted;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(OffsetDateTime modified) {
        this.modified = modified;
    }
}
