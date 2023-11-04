package com.danovska01.data_validation_demo.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {

    @NotNull(message = "Username is required")
    @Size(min = 3, max = 15, message = "The username must be between 3 and 15 characters.")
    private String username;
    @NotNull(message = "Password is required")
    @Size(min = 3, max = 15, message = "The password must be between 3 and 15 characters.")
    private String password;

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginModel(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
