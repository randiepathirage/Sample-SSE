package com.example.API.stream;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Subject {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String format, email, iss, phone_number;

    public Subject(String format, String detail) {
        this.format = format;
        if (format.equals("email"))
            this.email = detail;
        if (format.equals("iss_sub"))
            this.iss = detail;
        if (format.equals("phone"))
            this.phone_number = detail;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
