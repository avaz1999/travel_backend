package com.example.travel_backend.service;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.user.UserEditRequest;
import com.example.travel_backend.dto.user.UserRequest;

public interface UserService {
    ApiResponse<?> getAll();
    ApiResponse<?> getOne(Long id);
    ApiResponse<?> edit(Long id, UserEditRequest request);
    ApiResponse<?> delete(Long id);
}
