package com.example.travel_backend.controller;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.auth.LoginRequest;
import com.example.travel_backend.dto.auth.TokenRequest;
import com.example.travel_backend.dto.auth.TokenResponse;
import com.example.travel_backend.dto.user.UserRequest;
import com.example.travel_backend.service.AuthService;
import com.example.travel_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    @PostMapping("register")
    public ResponseEntity<?> create(@RequestBody UserRequest request){
        return ApiResponse.controller(service.register(request));
    }
    @GetMapping("login")
    private ResponseEntity<?> login(@RequestBody LoginRequest request){
        return ApiResponse.controller(service.login(request));
    }
    @PostMapping("token")
    public TokenResponse register(@RequestBody TokenRequest request){
        return service.getToken(request);
    }
}
