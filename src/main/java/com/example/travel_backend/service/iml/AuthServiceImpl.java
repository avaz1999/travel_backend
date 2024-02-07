package com.example.travel_backend.service.iml;

import com.example.travel_backend.dto.auth.TokenRequest;
import com.example.travel_backend.dto.auth.TokenResponse;
import com.example.travel_backend.entity.User;
import com.example.travel_backend.exception.user.BadCredentialsException;
import com.example.travel_backend.exception.user.GrantTypeAndAuthNotCompatibleException;
import com.example.travel_backend.exception.user.UserNotFoundException;
import com.example.travel_backend.repository.UserRepository;
import com.example.travel_backend.security.JwtService;
import com.example.travel_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;



    @Override
    public TokenResponse getToken(TokenRequest request) {


        return null;
    }
}
