package com.example.phoenix.SignUpLayout;

public class User {
    String  student_firstName;
    String student_lastName;
    String student_e_Mail;
    String student_password;
    String ver_password;
    String student_phone;
    String student_what_App_number;
    String student_date;

    public User(String student_firstName, String student_lastName, String student_e_Mail,
                String student_password, String ver_password,
                String student_phone, String student_what_App_number) {
        this.student_firstName = student_firstName;
        this.student_lastName = student_lastName;
        this.student_e_Mail = student_e_Mail;
        this.student_password = student_password;
        this.ver_password = ver_password;
        this.student_phone = student_phone;
        this.student_what_App_number = student_what_App_number;
        this.student_date = student_date;
    }

    public String getStudent_firstName() {
        return student_firstName;
    }

    public String getStudent_lastName() {
        return student_lastName;
    }

    public String getStudent_e_Mail() {
        return student_e_Mail;
    }

    public String getStudent_password() {
        return student_password;
    }

    public String getVer_password() {
        return ver_password;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public String getStudent_what_App_number() {
        return student_what_App_number;
    }

    public String getStudent_date() {
        return student_date;
    }



}
