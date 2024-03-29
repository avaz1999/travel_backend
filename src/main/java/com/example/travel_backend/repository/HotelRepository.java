package com.example.travel_backend.repository;

import com.example.travel_backend.entity.Hotel;
import com.example.travel_backend.entity.TurPacket;
import com.example.travel_backend.repository.base.BaseRepository;

import java.util.List;

public interface HotelRepository extends BaseRepository<Hotel> {
    List<Hotel> findAllByTravelPlaceAndDeletedFalse(TurPacket travelPlace);
}
