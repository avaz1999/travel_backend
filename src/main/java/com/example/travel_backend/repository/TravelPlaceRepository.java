package com.example.travel_backend.repository;

import com.example.travel_backend.entity.Country;
import com.example.travel_backend.entity.TravelPlace;
import com.example.travel_backend.repository.base.BaseRepository;

import java.util.List;

public interface TravelPlaceRepository extends BaseRepository<TravelPlace> {
    List<TravelPlace> findByCountryAndDeletedFalse(Country country);
}
