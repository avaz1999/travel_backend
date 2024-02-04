package com.example.travel_backend.repository;

import com.example.travel_backend.entity.Country;
import com.example.travel_backend.entity.NutritionCategory;
import com.example.travel_backend.entity.TurPacket;
import com.example.travel_backend.entity.TurPacketCategory;
import com.example.travel_backend.repository.base.BaseRepository;

import java.util.List;

public interface TurPacketRepository extends BaseRepository<TurPacket> {
    List<TurPacket> findAllByCountryAndDeletedFalse(Country country);

    List<TurPacket> findAllByNutritionCategoryAndDeletedFalse(List<NutritionCategory> nutritionCategories);
    List<TurPacket> findAllByTurPacketCategoryAndDeletedFalse(List<TurPacketCategory> turPacketCategories);
}
