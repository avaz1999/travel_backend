package com.example.travel_backend.service;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.user.UserRequest;
import org.springframework.data.domain.Pageable;

public interface UserService {
    ApiResponse<?> create(UserRequest request);
    ApiResponse<?> getAll();
    ApiResponse<?> getOne(Long id);
    ApiResponse<?> edit(Long id,UserRequest request);
    ApiResponse<?> delete(Long id);
}
