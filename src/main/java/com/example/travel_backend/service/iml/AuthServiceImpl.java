package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.auth.LoginRequest;
import com.example.travel_backend.dto.auth.TokenRequest;
import com.example.travel_backend.dto.auth.TokenResponse;
import com.example.travel_backend.dto.user.UserRequest;
import com.example.travel_backend.entity.User;
import com.example.travel_backend.exception.security.GrantTypeException;
import com.example.travel_backend.exception.security.PasswordNotEqualException;
import com.example.travel_backend.exception.user.BadCredentialsException;
import com.example.travel_backend.exception.user.GrantTypeAndAuthNotCompatibleException;
import com.example.travel_backend.exception.user.UserAlredyExistsException;
import com.example.travel_backend.exception.user.UserNotFoundException;
import com.example.travel_backend.repository.UserRepository;
import com.example.travel_backend.security.JwtService;
import com.example.travel_backend.service.AuthService;
import com.example.travel_backend.utils.ResMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public TokenResponse getToken(TokenRequest request) {
        if ("password".equals(request.getGrantType())) {
            if (request.getUsername() != null && request.getPassword() != null) {
                Optional<User> optionalUser = repository.findByUsernameAndDeletedFalse(request.getUsername());
                if (optionalUser.isEmpty()) throw new BadCredentialsException();
                User user = optionalUser.get();
                if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                    throw new BadCredentialsException();
                }
                return jwtService.generateToken(user);
            }
            throw new GrantTypeAndAuthNotCompatibleException();
        } else if ("refresh_token".equals(request.getGrantType())) {
            if (request.getRefreshToken() != null) {
                if (jwtService.isTokenValid(request.getRefreshToken())) {
                    String username = jwtService.extractUsername(request.getRefreshToken());
                    Optional<User> optionalUser = repository.findByUsernameAndDeletedFalse(username);
                    if (optionalUser.isEmpty()) throw new BadCredentialsException();
                    User user = optionalUser.get();
                    return jwtService.generateToken(user);
                }
                throw new BadCredentialsException();
            }
            throw new GrantTypeAndAuthNotCompatibleException();
        }
        throw new GrantTypeException();
    }

    @Override
    public ApiResponse<?> register(UserRequest request) {
        if (repository.existsByEmailAndDeletedFalse(request.getEmail())) throw new UserAlredyExistsException();
        if (!Objects.equals(request.getPassword(), request.getPassword2())) throw new PasswordNotEqualException();
        User user = repository.save(User.create(request));
        return new ApiResponse<>(true, ResMessage.SUCCESS, jwtService.generateToken(user));
    }

    @Override
    public ApiResponse<?> login(LoginRequest request) {
        User user = repository.findByEmailAndDeletedFalse(request.getEmail());
        if (user == null) throw new UserNotFoundException();
        return new ApiResponse<>(true, ResMessage.SUCCESS, jwtService.generateToken(user));
    }
}
