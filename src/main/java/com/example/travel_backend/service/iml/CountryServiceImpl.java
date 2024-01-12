package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.country.CountryRequest;
import com.example.travel_backend.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    @Override
    public ApiResponse<?> create(CountryRequest request) {
        return null;
    }

    @Override
    public ApiResponse<?> getAll() {
        return null;
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        return null;
    }

    @Override
    public ApiResponse<?> edit(Long id, CountryRequest request) {
        return null;
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        return null;
    }
}
