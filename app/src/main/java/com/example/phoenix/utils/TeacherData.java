package com.example.phoenix.utils;

import java.util.Date;

public class TeacherData {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String whats;
    private Date birthday;
    private String id;
    private String imageUrl;

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWhats(String whats) {
        this.whats = whats;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
