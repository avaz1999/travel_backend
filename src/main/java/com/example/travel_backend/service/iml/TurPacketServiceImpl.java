package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.travel.TurPacketEditRequest;
import com.example.travel_backend.dto.travel.TurPacketRequest;
import com.example.travel_backend.dto.travel.TravelPlaceResponse;
import com.example.travel_backend.dto.travel.TravelPlaceWithHotelResponse;
import com.example.travel_backend.entity.Country;
import com.example.travel_backend.entity.Hotel;
import com.example.travel_backend.entity.NutritionCategory;
import com.example.travel_backend.entity.TurPacket;
import com.example.travel_backend.exception.country.CountryNotFoundException;
import com.example.travel_backend.exception.ntrition.NutritionCategoryNotFoundException;
import com.example.travel_backend.exception.travel.TravelPlaceNotFoundException;
import com.example.travel_backend.repository.*;
import com.example.travel_backend.service.TurPacketService;
import com.example.travel_backend.utils.ResMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TurPacketServiceImpl implements TurPacketService {
    private final TurPacketRepository repository;
    private final CountryRepository countryRepository;
    private final HotelRepository hotelRepository;
    private final TurPacketCategoryRepository categoryRepository;
    private final NutritionCategoryRepository nutritionCategoryRepository;

    public TurPacketServiceImpl(TurPacketRepository repository, CountryRepository countryRepository, HotelRepository hotelRepository, TurPacketCategoryRepository categoryRepository, NutritionCategoryRepository nutritionCategoryRepository) {
        this.repository = repository;
        this.countryRepository = countryRepository;
        this.hotelRepository = hotelRepository;
        this.categoryRepository = categoryRepository;
        this.nutritionCategoryRepository = nutritionCategoryRepository;
    }

    @Override
    public ApiResponse<?> create(Long countryId,TurPacketRequest request) {
        Country country = countryRepository.findByIdAndDeletedFalse(countryId);
        List<Long> list = request.getNutritionCategoryId().stream().filter(
                nutritionId -> {
                    NutritionCategory nutritionCategory = nutritionCategoryRepository.findByIdAndDeletedFalse(nutritionId);
                    if (nutritionCategory == null) throw new NutritionCategoryNotFoundException(nutritionId);
                    return true;
                }
        ).toList();
        if (country == null) throw new CountryNotFoundException();
        TurPacket travelPlace = TurPacket.toEntity(request, country);
        repository.save(travelPlace);
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }

    @Override
    public ApiResponse<?> getAll(Pageable pageable) {
        List<TravelPlaceResponse> travelPlaceResponses =
                repository.findAllNotDeleted().stream().map(TravelPlaceResponse::toDto).toList();
        return new ApiResponse<>(true, ResMessage.SUCCESS, travelPlaceResponses);
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
