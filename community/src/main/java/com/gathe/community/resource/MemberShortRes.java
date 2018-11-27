package com.gathe.community.resource;

import com.gathe.community.domain.Member;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "member")
@XmlType(propOrder = {"name", "photo"})
public class MemberShortRes implements MemberRes {

    private String id;
    private String name;
    private String photo;


    public MemberShortRes() {
    }

    public MemberShortRes(Member member) {
        this.id = member.getId().toString();
        this.name = member.getName();
        this.photo = member.getPhoto();
    }


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

    @XmlElement
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
