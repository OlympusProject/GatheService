package com.gathe.community.resource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "members")
public class MembersRes {

    // -- members ---------------------------------------------------------------------------------- //
    private List<MemberShortRes> members;




    // -- constructors ----------------------------------------------------------------------------- //
    public MembersRes() {
    }

    public MembersRes(List<MemberShortRes> members) {
        this.members = members;
    }




    // -- getters & setters ------------------------------------------------------------------------- //
    @XmlElement
    public List<MemberShortRes> getMembers() {
        return members;
    }

    public void setMembers(List<MemberShortRes> members) {
        this.members = members;
    }
}
