package com.gathe.user.resources;

import com.gathe.user.domain.User;
import com.gathe.user.exception.UserNotFoundException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class UserShortRes implements UserRes {

    private String id;
    private String name;
    private String email;

    // -- constructors ------------------------------------------------------------------------------
    public UserShortRes() {
    }

    public UserShortRes(User user) {
        if (user == null) throw new UserNotFoundException("");
        else {
            this.id = user.getId().toString();
            this.name = user.getFirstName() + " " + user.getLastName();
            this.email = user.getEmail();
        }
    }

    // -- getters & setters -------------------------------------------------------------------------
    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String totalMembers) {
        this.email = totalMembers;
    }

}
