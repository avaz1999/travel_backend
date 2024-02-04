package com.example.travel_backend.dto.travel;

import com.example.travel_backend.dto.nutritioncategory.NutritionCategoryResponse;
import com.example.travel_backend.dto.turpacketcategory.TurPacketCategoryResponse;
import com.example.travel_backend.entity.NutritionCategory;
import com.example.travel_backend.entity.TurPacket;
import com.example.travel_backend.entity.TurPacketCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurPacketResponse {
    private String name;
    private String description;
    private String duration;
    private Date leaveDate;
    private Date returnDate;
    private BigDecimal price;
    private Double discount;
    private String priceIncludes;
    private String priceNotIncludes;
    private String insurance;
    private boolean visa;
    private Byte numberOfPeople;
    private Double rate;
    private Boolean active;
    private Long countryId;
    private List<NutritionCategoryResponse> nutritionCategory;
    private List<TurPacketCategoryResponse> turPacketCategory;

    public static TurPacketResponse toDto(TurPacket travelPlace) {
        TurPacketResponse response = new TurPacketResponse();
        response.setName(travelPlace.getName());
        response.setDescription(travelPlace.getDescription());
        response.setDuration(travelPlace.getDuration());
        response.setLeaveDate(travelPlace.getLeaveDate());
        response.setReturnDate(travelPlace.getReturnDate());
        response.setPrice(travelPlace.getPrice());
        response.setDiscount(travelPlace.getDiscount());
        response.setPriceIncludes(travelPlace.getPriceIncludes());
        response.setPriceNotIncludes(travelPlace.getPriceNotIncludes());
        response.setInsurance(travelPlace.getInsurance());
        response.setVisa(travelPlace.isVisa());
        response.setNumberOfPeople(travelPlace.getNumberOfPeople());
        response.setRate(travelPlace.getRate());
        response.setActive(travelPlace.getActive());
        response.setCountryId(travelPlace.getId());
        response.setNutritionCategory(travelPlace.getNutritionCategory().stream().map(NutritionCategoryResponse::toDto).toList());
        response.setTurPacketCategory(travelPlace.getTurPacketCategory().stream().map(TurPacketCategoryResponse::toDto).toList());
        return response;
    }


}
