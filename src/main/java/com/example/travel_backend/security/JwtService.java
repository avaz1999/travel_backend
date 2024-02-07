package com.example.travel_backend.security;

import com.example.travel_backend.dto.auth.TokenResponse;
import com.example.travel_backend.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${application.security.jwt.secret-key}")
    private String secret;

    @Value("${application.security.jwt.expiration}")
    private long expirationAccessToken;

    @Value("${application.security.jwt.refresh-token.expiration}")
    private long expirationRefreshToken;

    private final String tokenType = "token_type";
    private final String username = "username";
    private final String userId = "userId";
    private final String role = "role";
    private final String refreshToken = "refresh_token";
    private final String accessToken = "access_token";

    public String extractUsername(String token) {
        return extractClaims(token, obj -> obj.get(username, String.class));
    }

    public TokenResponse generateToken(User user) {
        byte[] secretBytes = io.jsonwebtoken.io.Decoders.BASE64.decode(secret);
        String issuer = "tur-agency";
        Date now = new Date();
        Date accessTokenExpiration = new Date(now.getTime() + expirationAccessToken);
        Date refreshTokenExpiration = new Date(now.getTime() + expirationRefreshToken);

        Map<String, Object> accessTokenClaims = new HashMap<>();
        accessTokenClaims.put(userId, user.getId());
        accessTokenClaims.put(username, user.getUsername());
        accessTokenClaims.put(role, user.getRole());
        accessTokenClaims.put(tokenType, accessToken);
        String accessToken = Jwts.builder()
                .setIssuer(issuer)
                .setClaims(accessTokenClaims)
                .setIssuedAt(now)
                .setExpiration(accessTokenExpiration)
                .signWith(Keys.hmacShaKeyFor(secretBytes), SignatureAlgorithm.HS256)
                .compact();

        Map<String, Object> refreshTokenClaims = new HashMap<>();
        refreshTokenClaims.put(username, user.getUsername());
        refreshTokenClaims.put(tokenType, refreshToken);
        String refreshToken = Jwts.builder()
                .setIssuer(issuer)
                .setClaims(refreshTokenClaims)
                .setIssuedAt(now)
                .setExpiration(refreshTokenExpiration)
                .signWith(Keys.hmacShaKeyFor(secretBytes), SignatureAlgorithm.HS256)
                .compact();

        return new TokenResponse(accessToken, expirationAccessToken, refreshToken);
    }

    public boolean isTokenValid(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return !claims.getExpiration().before(new Date());
        } catch (JwtException ex) {
            return false;
        }
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolve) {
        Claims claims =
                Jwts
                        .parserBuilder()
                        .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secret)))
                        .build()
                        .parseClaimsJws(token)
                        .getBody();
        return claimsResolve.apply(claims);
    }
}
