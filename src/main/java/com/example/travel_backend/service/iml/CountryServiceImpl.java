package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.country.CountryEditRequest;
import com.example.travel_backend.dto.country.CountryRequest;
import com.example.travel_backend.dto.country.CountryResponse;
import com.example.travel_backend.dto.country.GetOneCountryResponse;
import com.example.travel_backend.dto.travel.TravelPlaceResponse;
import com.example.travel_backend.entity.Country;
import com.example.travel_backend.entity.TurPacket;
import com.example.travel_backend.exception.country.CountryNotFoundException;
import com.example.travel_backend.repository.CountryRepository;
import com.example.travel_backend.repository.TurPacketRepository;
import com.example.travel_backend.service.CountryService;
import com.example.travel_backend.utils.ResMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repository;
    private final TurPacketRepository turPacketRepository;
    private final TurPacketRepository travelPlaceRepository;

    public CountryServiceImpl(CountryRepository repository, TurPacketRepository turPacketRepository, TurPacketRepository travelPlaceRepository) {
        this.repository = repository;
        this.turPacketRepository = turPacketRepository;
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
        List<TurPacket> travelPlaceList = travelPlaceRepository.findByCountryAndDeletedFalse(country);
        GetOneCountryResponse response = GetOneCountryResponse.toDto(country, travelPlaceList);
        return new ApiResponse<>(true, ResMessage.SUCCESS, response);
    }

    @Override
    public ApiResponse<?> countryTurPackets(Long countryId) {
        Country country = handleCountry(countryId);
        List<TravelPlaceResponse> travelPlaceResponses =
                turPacketRepository.findByCountryAndDeletedFalse(country).stream().map(TravelPlaceResponse::toDto).toList();
        return new ApiResponse<>(true, ResMessage.SUCCESS, travelPlaceResponses);
    }
    @Override
    public ApiResponse<?> edit(Long id, CountryEditRequest request) {
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
