package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.nutritioncategory.NutritionCategoryRequest;
import com.example.travel_backend.entity.NutritionCategory;
import com.example.travel_backend.entity.TurPacket;
import com.example.travel_backend.exception.ntrition.NutritionCategoryNotFoundException;
import com.example.travel_backend.repository.NutritionCategoryRepository;
import com.example.travel_backend.repository.TurPacketRepository;
import com.example.travel_backend.service.NutritionCategoryService;
import com.example.travel_backend.utils.ResMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NutritionCategoryServiceImpl implements NutritionCategoryService {
    private final NutritionCategoryRepository repository;
    private final TurPacketRepository turPacketRepository;

    public NutritionCategoryServiceImpl(NutritionCategoryRepository repository, TurPacketRepository turPacketRepository) {
        this.repository = repository;
        this.turPacketRepository = turPacketRepository;
    }

    @Override
    public ApiResponse<?> create(NutritionCategoryRequest request) {
        repository.save(new NutritionCategory(request.getName()));
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }

    @Override
    public ApiResponse<?> getAll() {
        return new ApiResponse<>(true,ResMessage.SUCCESS,repository.findAll().stream().map(NutritionCategoryRequest::toDto));
    }

    @Override
    public ApiResponse<?> edit(Long id, NutritionCategoryRequest request) {
        NutritionCategory category = repository.findByIdAndDeletedFalse(id);
        if (category == null) throw new NutritionCategoryNotFoundException();
        category.setName(request.getName() != null ? request.getName() : category.getName());
        repository.save(category);
        return new ApiResponse<>(true,ResMessage.SUCCESS);
    }

    @Override
    public ApiResponse<?> delete(Long id) {
            NutritionCategory category = repository.findByIdAndDeletedFalse(id);
            if (category == null) throw new NutritionCategoryNotFoundException();
            category.setDeleted(true);
            List<Long> turPacketIds = turPacketRepository
                    .findAllByNutritionCategoryAndDeletedFalse(Collections.singletonList(category))
                    .stream()
                    .peek(turPacket -> turPacket.getNutritionCategory().remove(category))
                    .peek(turPacketRepository::save)
                    .map(TurPacket::getId)
                    .toList();
            return new ApiResponse<>(true, ResMessage.SUCCESS);
        }
    }

