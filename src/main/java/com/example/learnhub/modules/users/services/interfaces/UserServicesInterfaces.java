package com.example.learnhub.modules.users.services.interfaces;

import com.example.learnhub.modules.users.dtos.LoginReponse;
import com.example.learnhub.modules.users.dtos.LoginRequest;

public interface UserServicesInterfaces {
    LoginReponse login(LoginRequest request);
}
