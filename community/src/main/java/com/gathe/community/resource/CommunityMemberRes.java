package com.gathe.community.resource;

import com.gathe.community.domain.Community;
import com.gathe.community.domain.MemberCommunityHolder;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "community")
@XmlType(propOrder = {"name", "members"})
public class CommunityMemberRes implements CommunityRes {


    // -- members ---------------------------------------------------------------------------------- //
    private String id;
    private String name;
    private MembersRes members;





    // -- constructors ----------------------------------------------------------------------------- //
    public CommunityMemberRes() {
    }

    public CommunityMemberRes(Community community) {
        this.id = community.getId().toString();
        this.name = community.getName();
        List<MemberShortRes> members = community.getMembers()
                .stream()
                .filter(MemberCommunityHolder::isMember)
                .map(current -> new MemberShortRes(current.getMember()))
                .collect(Collectors.toList());
        this.members = new MembersRes(members);
    }





    // -- getters & setters ------------------------------------------------------------------------- //
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
    public MembersRes getMembers() {
        return members;
    }

    public void setMembers(MembersRes members) {
        this.members = members;
    }
}
