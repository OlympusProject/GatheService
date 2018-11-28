package com.gathe.user.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.time.OffsetDateTime;
import java.util.List;

public class User implements Domain {
    private Long id;

    @Email
    private String email;

    private String firstName;
    private String lastName;

    @Past
    private OffsetDateTime birthDate;

    private List<String> interests;
    private String address;
    private String profilePhoto;
    private String about;
    private OffsetDateTime created;
    private OffsetDateTime deleted;
    private OffsetDateTime modified;

    public User(){
    }

    public User (User user){
        this.id = user.id;
        this.email = user.email;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.birthDate = user.birthDate;
        this.interests = user.interests;
        this.address = user.address;
        this.profilePhoto = user.profilePhoto;
        this.about = user.about;
        this.created = user.created;
        this.deleted = user.deleted;
        this.modified = user.modified;
    }


    public User(Long id, String email, String firstName, String lastName ) {
        super();
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(Long id) {
        this.id = id;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public OffsetDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(OffsetDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
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

