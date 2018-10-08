package com.zeus.core.domain;

/**
 * An abstract class of any Domain.
 * This class provides any instance variables that is common for all kind of Domain sub-classes.
 */
public abstract class AnyDomain implements Domain {

    // -- instance variables ------------------------------------------------------------------------------------------
    protected String name;



    // -- instance variables ------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
