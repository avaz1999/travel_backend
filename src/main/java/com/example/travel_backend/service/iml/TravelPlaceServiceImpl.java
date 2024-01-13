package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.travel.TravelPlaceEditRequest;
import com.example.travel_backend.dto.travel.TravelPlaceRequest;
import com.example.travel_backend.repository.TravelPlaceRepository;
import com.example.travel_backend.service.TravelPlaceService;
import org.springframework.data.domain.Pageable;

public class TravelPlaceServiceImpl implements TravelPlaceService {
    private TravelPlaceRepository repository;

    public TravelPlaceServiceImpl(TravelPlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApiResponse<?> create(TravelPlaceRequest request) {

        return null;
    }

    @Override
    public ApiResponse<?> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ApiResponse<?> getByCountryId(Long countryId) {
        return null;
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        return null;
    }

    @Override
    public ApiResponse<?> edit(Long id, TravelPlaceEditRequest request) {
        return null;
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        return null;
    }
}
