package com.example.travel_backend.repository;

import com.example.travel_backend.entity.Hotel;
import com.example.travel_backend.entity.TravelPlace;
import com.example.travel_backend.repository.base.BaseRepository;

import java.util.List;

public interface HotelRepository extends BaseRepository<Hotel> {
    List<Hotel> findAllByTravelPlaceAndDeletedFalse(TravelPlace travelPlace);
}
