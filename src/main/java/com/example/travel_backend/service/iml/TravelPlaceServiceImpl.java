package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.travel.TravelPlaceEditRequest;
import com.example.travel_backend.dto.travel.TravelPlaceRequest;
import com.example.travel_backend.dto.travel.TravelPlaceResponse;
import com.example.travel_backend.dto.travel.TravelPlaceWithHotelResponse;
import com.example.travel_backend.entity.Country;
import com.example.travel_backend.entity.Hotel;
import com.example.travel_backend.entity.TravelPlace;
import com.example.travel_backend.exception.country.CountryNotFoundException;
import com.example.travel_backend.exception.travel.TravelPlaceNotFoundException;
import com.example.travel_backend.repository.CountryRepository;
import com.example.travel_backend.repository.HotelRepository;
import com.example.travel_backend.repository.TravelPlaceRepository;
import com.example.travel_backend.service.TravelPlaceService;
import com.example.travel_backend.utils.ResMessage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class TravelPlaceServiceImpl implements TravelPlaceService {
    private final TravelPlaceRepository repository;
    private final CountryRepository countryRepository;
    private final HotelRepository hotelRepository;

    public TravelPlaceServiceImpl(TravelPlaceRepository repository, CountryRepository countryRepository, HotelRepository hotelRepository) {
        this.repository = repository;
        this.countryRepository = countryRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public ApiResponse<?> create(TravelPlaceRequest request) {
        Country country = countryRepository.findByIdAndDeletedFalse(request.getCountryId());
        if (country == null) throw new CountryNotFoundException();
        TravelPlace travelPlace = TravelPlace.toEntity(request, country);
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
    public ApiResponse<?> getByCountryId(Long countryId) {
        Country country = handleCountry(countryId);
        List<TravelPlaceResponse> travelPlaceResponses =
                repository.findByCountryAndDeletedFalse(country).stream().map(TravelPlaceResponse::toDto).toList();
        return new ApiResponse<>(true, ResMessage.SUCCESS, travelPlaceResponses);
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        TravelPlace travelPlace = handleTravelPlace(id);
        List<Hotel> hotels = hotelRepository.findAllByTravelPlaceAndDeletedFalse(travelPlace);
        TravelPlaceWithHotelResponse response = TravelPlaceWithHotelResponse.toDtoWithHotel(travelPlace, hotels);
        return new ApiResponse<>(true,ResMessage.SUCCESS,response);
    }

    @Override
    public ApiResponse<?> edit(Long id, TravelPlaceEditRequest request) {
        TravelPlace travelPlace = handleTravelPlace(id);
        TravelPlace edit = TravelPlaceEditRequest.edit(travelPlace, request);
        return new ApiResponse<>(true,ResMessage.SUCCESS);
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        TravelPlace travelPlace = handleTravelPlace(id);
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

    private TravelPlace handleTravelPlace(Long id) {
        if (id == null) throw new TravelPlaceNotFoundException();
        TravelPlace travelPlace = repository.findByIdAndDeletedFalse(id);
        if (travelPlace == null) throw new TravelPlaceNotFoundException();
        return travelPlace;
    }
}
