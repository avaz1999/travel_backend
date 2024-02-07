package com.example.travel_backend.service;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.auth.LoginRequest;
import com.example.travel_backend.dto.auth.TokenRequest;
import com.example.travel_backend.dto.auth.TokenResponse;
import com.example.travel_backend.dto.user.UserRequest;

public interface AuthService {
    TokenResponse getToken(TokenRequest request);
    ApiResponse<?> register(UserRequest request);
    ApiResponse<?> login(LoginRequest request);
}
