package com.gathe.community.resource;

import com.gathe.community.domain.Community;
import com.gathe.community.exception.BadResourceConversionException;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "community")
public class CommunityShortRes implements CommunityRes {

    // -- members -----------------------------------------------------------------------------------
    private String id;
    private String name;
    private String totalMembers;




    // -- constructors ------------------------------------------------------------------------------
    public CommunityShortRes() {
        // for JAXB
    }

    public CommunityShortRes(Community community) {
        if (community == null) throw new BadResourceConversionException();
        else {
            this.id = community.getId().toString();
            this.name = community.getName();
            this.totalMembers = Integer.toString(community.getNbOfMembers());
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

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "totalmembers")
    public String getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(String totalMembers) {
        this.totalMembers = totalMembers;
    }
}


