package com.example.travel_backend.service;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.country.CountryEditRequest;
import com.example.travel_backend.dto.country.CountryRequest;

public interface CountryService {
    ApiResponse<?> create(CountryRequest request);
    ApiResponse<?> getAll();
    ApiResponse<?> getOne(Long id);
    ApiResponse<?> edit(Long id, CountryEditRequest request);
    ApiResponse<?> delete(Long id);
    ApiResponse<?> countryTurPackets(Long countryId);
}
