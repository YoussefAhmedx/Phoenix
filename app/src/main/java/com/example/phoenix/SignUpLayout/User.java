package com.example.phoenix.SignUpLayout;

public class User {
    String id,select_type, firstName, e_Mail,  Password, phone,  whats_app_num, date;

    public User(String id, String select_type, String firstName, String e_Mail, String password, String phone, String whats_app_num, String date) {
        this.id = id;
        this.select_type = select_type;
        this.firstName = firstName;
        this.e_Mail = e_Mail;
        this.Password = password;
        this.phone = phone;
        this.whats_app_num = whats_app_num;
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSelect_type(String select_type) {
        this.select_type = select_type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setE_Mail(String e_Mail) {
        this.e_Mail = e_Mail;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWhats_app_num(String whats_app_num) {
        this.whats_app_num = whats_app_num;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getSelect_type() {
        return select_type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getE_Mail() {
        return e_Mail;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhone() {
        return phone;
    }

    public String getWhats_app_num() {
        return whats_app_num;
    }

    public String getDate() {
        return date;
    }


}
