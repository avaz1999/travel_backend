package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.turpacketcategory.TurPacketCategoryRequest;
import com.example.travel_backend.dto.turpacketcategory.TurPacketCategoryResponse;
import com.example.travel_backend.entity.TurPacket;
import com.example.travel_backend.entity.TurPacketCategory;
import com.example.travel_backend.exception.turpacket.TurPacketNotFoundException;
import com.example.travel_backend.exception.turpacketcategory.TurPacketCategoryAlreadyExistException;
import com.example.travel_backend.repository.TurPacketCategoryRepository;
import com.example.travel_backend.repository.TurPacketRepository;
import com.example.travel_backend.service.TurPacketCategoryService;
import com.example.travel_backend.utils.ResMessage;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TurPacketCategoryServiceImpl implements TurPacketCategoryService {
    private final TurPacketCategoryRepository repository;
    private final TurPacketRepository turPacketRepository;

    public TurPacketCategoryServiceImpl(TurPacketCategoryRepository repository, TurPacketRepository turPacketRepository) {
        this.repository = repository;
        this.turPacketRepository = turPacketRepository;
    }

    @Override
    public ApiResponse<?> create(TurPacketCategoryRequest request) {
        if (repository.existsByNameAndDeletedFalse(request.getName()))
            throw new TurPacketCategoryAlreadyExistException();
        repository.save(new TurPacketCategory(request.getName()));
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }

    @Override
    public ApiResponse<?> getAll() {
        return new ApiResponse<>(true, ResMessage.SUCCESS, repository.findAll().stream().map(TurPacketCategoryResponse::toDto));
    }

    @Override
    public ApiResponse<?> edit(Long id, TurPacketCategoryRequest request) {
        TurPacketCategory category = repository.findByIdAndDeletedFalse(id);
        if (category == null) throw new TurPacketNotFoundException();
        category.setName(request.getName() != null ? request.getName() : category.getName());
        repository.save(category);
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }

    @Override
    public ApiResponse<?> delete(Long id) {
//        TurPacketCategory category = repository.findByIdAndDeletedFalse(id);
//        if (category == null) throw new TurPacketNotFoundException();
//        category.setDeleted(true);
//        repository.save(category);
//        List<Long> list = turPacketRepository.findByTurPacketCategoryAndDeletedFalse(Collections.singletonList(category))
//                .stream()
//                .peek(turPacket -> turPacket.getTurPacketCategory().remove(category))
//                .peek(turPacketRepository::save)
//                .map(TurPacket::getId)
//                .toList();
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }
}
