package com.example.travel_backend.dto.user;

import com.example.travel_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponse {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String role;
    private String username;

    public static UserResponse toDto(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setUsername(user.getUsername());
        response.setRole(String.valueOf(user.getRole()));
        return response;
    }

    public static User edit(User user, UserRequest request) {
        user.setFullName(request.getFullName() != null ? request.getFullName() : user.getFullName());
        user.setUsername(request.getUsername() != null ? request.getUsername() : user.getUsername());
        user.setPassword(request.getPhoneNumber() != null? request.getPassword():user.getPhoneNumber());
        return user;
    }
}
