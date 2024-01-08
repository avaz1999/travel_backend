package com.example.travel_backend.dto.user;

import com.example.travel_backend.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequest {
    private Long id;
    private String fullName;
    @Size(min = 12)
    private String phoneNumber;
    @NotBlank
    private String username;
    @NotBlank @Size(min = 8)
    private String password;
}
