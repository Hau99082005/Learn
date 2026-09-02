package com.example.learnhub.modules.users.dtos;

public class LoginReponse {
    private final String token;
    private final userDTO user;

    public LoginReponse(String token, userDTO user) {
        this.token = token;
        this.user = user;
    }
    public String getToken() {
        return token;
    }
    public userDTO getUser() {
        return user;
    }
    
}
