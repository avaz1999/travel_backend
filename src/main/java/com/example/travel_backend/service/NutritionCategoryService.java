package com.example.travel_backend.service;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.nutritioncategory.NutritionCategoryRequest;
import com.example.travel_backend.dto.nutritioncategory.NutritionCategoryResponse;

public interface NutritionCategoryService {
    ApiResponse<?> create(NutritionCategoryRequest request);
    ApiResponse<?> getAll();
    ApiResponse<?> edit(Long id, NutritionCategoryRequest request);
    ApiResponse<?> delete(Long id);
}
