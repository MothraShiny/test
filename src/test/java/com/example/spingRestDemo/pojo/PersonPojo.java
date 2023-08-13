package com.example.spingRestDemo.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class PersonPojo {
    private String name;

    private String password;

    private String email;

    public PersonPojo(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
