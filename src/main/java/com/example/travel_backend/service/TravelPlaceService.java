package com.example.travel_backend.service;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.travel.TravelPlaceEditRequest;
import com.example.travel_backend.dto.travel.TravelPlaceRequest;
import org.springframework.data.domain.Pageable;

public interface TravelPlaceService {
    ApiResponse<?> create(TravelPlaceRequest request);
    ApiResponse<?> getAll(Pageable pageable);
    ApiResponse<?> getByCountryId(Long countryId);
    ApiResponse<?> getOne(Long id);
    ApiResponse<?> edit(Long id, TravelPlaceEditRequest request);
    ApiResponse<?> delete(Long id);
}
