package com.example.travel_backend.service;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.turpacketcategory.TurPacketCategoryRequest;
import com.example.travel_backend.entity.TurPacketCategory;

public interface TurPacketCategoryService {
    ApiResponse<?> create(TurPacketCategoryRequest request);
    ApiResponse<?> getAll();
    ApiResponse<?> edit(Long id, TurPacketCategoryRequest request);
    ApiResponse<?> delete(Long id);
}
