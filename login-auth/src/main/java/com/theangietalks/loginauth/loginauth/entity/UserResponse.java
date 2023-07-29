package com.theangietalks.loginauth.loginauth.entity;

public class UserResponse {

    private String token;

    public UserResponse(String token) {
        this.token = token;
    }

    // Construtor, getters e setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
