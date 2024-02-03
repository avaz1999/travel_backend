package com.example.travel_backend.service;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.travel.TurPacketEditRequest;
import com.example.travel_backend.dto.travel.TurPacketRequest;
import org.springframework.data.domain.Pageable;

public interface TurPacketService {
    ApiResponse<?> create(Long countryId,TurPacketRequest request);
    ApiResponse<?> getAll(Pageable pageable);
    ApiResponse<?> getOne(Long id);
    ApiResponse<?> edit(Long id, TurPacketEditRequest request);
    ApiResponse<?> delete(Long id);
}
