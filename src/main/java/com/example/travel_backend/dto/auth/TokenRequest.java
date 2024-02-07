package com.example.travel_backend.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TokenRequest {
    private String username;
    private String password;
    private String grantType;
    private String refreshToken;
}
