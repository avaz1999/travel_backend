package com.example.travel_backend.service;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.auth.TokenRequest;
import com.example.travel_backend.dto.auth.TokenResponse;

public interface AuthService {
    TokenResponse getToken(TokenRequest request);
}
