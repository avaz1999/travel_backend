package com.example.travel_backend.dto.auth;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterRequest {
    @Size(min = 1, max = 64, message = "fullName length should be between 1 and 64")
    private String fullName;
    @NotBlank
    private String email;
    @NotBlank @Size(min = 8)
    private String password;
    @NotBlank @Size(min = 8)
    private String password2;
}
