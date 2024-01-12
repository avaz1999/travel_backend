package com.example.travel_backend.dto.user;

import com.example.travel_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AllUserResponse {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String role;

    public static AllUserResponse toDto(User user) {
        AllUserResponse response = new AllUserResponse();
        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setRole(String.valueOf(user.getRole()));
        return response;
    }
}
