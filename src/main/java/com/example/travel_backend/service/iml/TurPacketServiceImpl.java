package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.travel.TurPacketEditRequest;
import com.example.travel_backend.dto.travel.TurPacketRequest;
import com.example.travel_backend.dto.travel.TurPacketResponse;
import com.example.travel_backend.dto.travel.TravelPlaceWithHotelResponse;
import com.example.travel_backend.entity.*;
import com.example.travel_backend.exception.country.CountryNotFoundException;
import com.example.travel_backend.exception.ntrition.NutritionCategoryNotFoundException;
import com.example.travel_backend.exception.turpacket.TravelPlaceNotFoundException;
import com.example.travel_backend.exception.turpacket.TurPacketNotFoundException;
import com.example.travel_backend.repository.*;
import com.example.travel_backend.service.TurPacketService;
import com.example.travel_backend.utils.ResMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TurPacketServiceImpl implements TurPacketService {
    private final TurPacketRepository repository;
    private final CountryRepository countryRepository;
    private final HotelRepository hotelRepository;
    private final TurPacketCategoryRepository turPacketCategoryRepository;
    private final NutritionCategoryRepository nutritionCategoryRepository;

    public TurPacketServiceImpl(TurPacketRepository repository, CountryRepository countryRepository, HotelRepository hotelRepository, TurPacketCategoryRepository categoryRepository, NutritionCategoryRepository nutritionCategoryRepository) {
        this.repository = repository;
        this.countryRepository = countryRepository;
        this.hotelRepository = hotelRepository;
        this.turPacketCategoryRepository = categoryRepository;
        this.nutritionCategoryRepository = nutritionCategoryRepository;
    }

    @Override
    @Transactional
    public ApiResponse<?> create(Long countryId,TurPacketRequest request) {
        Country country = handleCountry(countryId);
        List<NutritionCategory> nutritionCategory = nutritionCategoryRepository.findAllById(request.getNutritionCategoryId())
                .stream().filter(nc  -> {
                    if (nc == null) throw new NutritionCategoryNotFoundException();
                    return false;
                }).toList();
        List<TurPacketCategory> turPacketCategory = turPacketCategoryRepository.findAllById(request.getTurPacketCategoryId())
                .stream().filter(tp ->{
                    if (tp == null) throw new TurPacketNotFoundException();
                    return false;
                }).toList();
        TurPacket travelPlace = TurPacket.toEntity(request, country,nutritionCategory,turPacketCategory);
        repository.save(travelPlace);
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }

    @Override
    public ApiResponse<?> getAll(Pageable pageable) {
        List<TurPacketResponse> responses =
                repository.findAllNotDeleted().stream().map(TurPacketResponse::toDto).toList();
        return new ApiResponse<>(true, ResMessage.SUCCESS, responses);
    }


    @Override
    public ApiResponse<?> getOne(Long id) {
        TurPacket travelPlace = handleTravelPlace(id);
        List<Hotel> hotels = hotelRepository.findAllByTravelPlaceAndDeletedFalse(travelPlace);
        TravelPlaceWithHotelResponse response = TravelPlaceWithHotelResponse.toDtoWithHotel(travelPlace, hotels);
        return new ApiResponse<>(true,ResMessage.SUCCESS,response);
    }

    @Override
    public ApiResponse<?> edit(Long id, TurPacketEditRequest request) {
        TurPacket travelPlace = handleTravelPlace(id);
        TurPacket edit = TurPacketEditRequest.edit(travelPlace, request);
        repository.save(edit);
        return new ApiResponse<>(true,ResMessage.SUCCESS);
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        TurPacket travelPlace = handleTravelPlace(id);
        travelPlace.setDeleted(true);
        repository.save(travelPlace);
        return new ApiResponse<>(true,ResMessage.SUCCESS);
    }

    private Country handleCountry(Long countryId) {
        if (countryId == null) throw new CountryNotFoundException();
        Country country = countryRepository.findByIdAndDeletedFalse(countryId);
        if (country == null) throw new CountryNotFoundException();
        return country;
    }

    private TurPacket handleTravelPlace(Long id) {
        if (id == null) throw new TravelPlaceNotFoundException();
        TurPacket travelPlace = repository.findByIdAndDeletedFalse(id);
        if (travelPlace == null) throw new TravelPlaceNotFoundException();
        return travelPlace;
    }
}
