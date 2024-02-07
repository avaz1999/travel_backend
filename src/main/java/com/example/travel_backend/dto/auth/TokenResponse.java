package com.example.travel_backend.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TokenResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Long expiresIn;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("token_type")
    private String tokenType = "Bearer";

    public TokenResponse(String accessToken, Long expirationAccessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.expiresIn = expirationAccessToken;
        this.refreshToken = refreshToken;
    }
}
