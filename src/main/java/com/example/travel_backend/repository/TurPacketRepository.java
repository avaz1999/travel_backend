package com.example.travel_backend.repository;

import com.example.travel_backend.entity.Country;
import com.example.travel_backend.entity.TurPacket;
import com.example.travel_backend.repository.base.BaseRepository;

import java.util.List;

public interface TurPacketRepository extends BaseRepository<TurPacket> {
    List<TurPacket> findByCountryAndDeletedFalse(Country country);
}
