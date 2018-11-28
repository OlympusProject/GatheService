package com.gathe.user.domain;

import java.util.ArrayList;
import java.util.List;

public class Community implements Domain {
    protected Long id;
    protected String name;
    protected List<String> interest = new ArrayList<>();

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

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }
}
