package com.example.learnhub.modules.users.services.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.learnhub.modules.users.dtos.LoginReponse;
import com.example.learnhub.modules.users.dtos.LoginRequest;
import com.example.learnhub.modules.users.dtos.userDTO;
import com.example.learnhub.modules.users.services.interfaces.UserServicesInterfaces;
import com.example.learnhub.services.BaseServices;

@Service
public class UserServices extends BaseServices implements UserServicesInterfaces {
    
    @Override
    public LoginReponse login(LoginRequest request) {
        try {
            // String email = request.getEmail();
            // String password_hash = request.getPassword_hash();
            String token = "random_token";
            userDTO user = new userDTO(1L, "hau99082005@gmail.com");
            return new LoginReponse(token, user);
            

        }catch(DataAccessException e) {
            throw new RuntimeException("Error occurred while logging in", e);
        }
    }
}
