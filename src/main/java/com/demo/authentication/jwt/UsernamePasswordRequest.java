package com.demo.authentication.jwt;

public class UsernamePasswordRequest {

    private String username;
    private String password;

    public UsernamePasswordRequest() {
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
}
