package com.example.phoenix.utils;

import java.util.Date;

public class StudentData {
    private String name;
    private String email;
    private String phone;
    private String whats;
    private Date birthday;
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
