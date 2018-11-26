package com.gathe.community.domain;

import java.time.OffsetDateTime;
import java.util.List;

public class Community {

    // -- members ----------------------------------------------------------------------------------
    private Long id;
    private String name;
    private List<String> interests;
    private List<Member> members;
    private List<User> joiningUser;
    private String about;
    private OffsetDateTime created;
    private OffsetDateTime deleted;
    private OffsetDateTime modified;


    public void addJoiningUser(User user){
        if (user != null) {
            this.joiningUser.add(user);
        }
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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
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
