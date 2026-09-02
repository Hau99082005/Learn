package com.example.learnhub.modules.users.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learnhub.modules.users.dtos.LoginReponse;
import com.example.learnhub.modules.users.dtos.LoginRequest;
import com.example.learnhub.modules.users.services.interfaces.UserServicesInterfaces;



@RestController
@RequestMapping("/api/auth")

public class AuthController {
    
    private final UserServicesInterfaces userServices;

    public AuthController(UserServicesInterfaces userServices) {
         this.userServices = userServices;
    } 
    @PostMapping("/login")
    public ResponseEntity<LoginReponse> login(@RequestBody LoginRequest request) {
    
       LoginReponse auth = userServices.login(request);
       return ResponseEntity.ok(auth);
    }
}
