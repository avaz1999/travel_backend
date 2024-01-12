package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.country.CountryRequest;
import com.example.travel_backend.dto.country.CountryResponse;
import com.example.travel_backend.dto.country.GetOneCountryResponse;
import com.example.travel_backend.entity.Country;
import com.example.travel_backend.entity.TravelPlace;
import com.example.travel_backend.exception.country.CountryNotFoundException;
import com.example.travel_backend.repository.CountryRepository;
import com.example.travel_backend.repository.TravelPlaceRepository;
import com.example.travel_backend.service.CountryService;
import com.example.travel_backend.utils.ResMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repository;
    private final TravelPlaceRepository travelPlaceRepository;

    public CountryServiceImpl(CountryRepository repository, TravelPlaceRepository travelPlaceRepository) {
        this.repository = repository;
        this.travelPlaceRepository = travelPlaceRepository;
    }

    @Override
    public ApiResponse<?> create(CountryRequest request) {
        Country country = Country.toEntity(request);
        repository.save(country);
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }

    @Override
    public ApiResponse<?> getAll() {
        List<Country> countries = repository.findAllNotDeleted();
        List<CountryResponse> responses = countries.stream().map(CountryResponse::toDto).toList();
        return new ApiResponse<>(true, ResMessage.SUCCESS, responses);
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        Country country = handleCountry(id);
        List<TravelPlace> travelPlaceList = travelPlaceRepository.findByCountryAndDeletedFalse(country);
        GetOneCountryResponse response = GetOneCountryResponse.toDto(country, travelPlaceList);
        return new ApiResponse<>(true, ResMessage.SUCCESS, response);
    }


    @Override
    public ApiResponse<?> edit(Long id, CountryRequest request) {
        Country country = handleCountry(id);
        Country edit = Country.edit(country, request);
        repository.save(edit);
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        Country country = handleCountry(id);
        country.setDeleted(true);
        repository.save(country);
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }

    private Country handleCountry(Long id) {
        if (id == null) throw new CountryNotFoundException();
        Country country = repository.findByIdAndDeletedFalse(id);
        if (country == null) throw new CountryNotFoundException();
        return country;
    }
}
