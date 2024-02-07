package com.example.travel_backend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEditRequest {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String username;
}
