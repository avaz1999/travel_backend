package com.example.travel_backend.dto.turpacket;

import com.example.travel_backend.dto.hotel.HotelResponse;
import com.example.travel_backend.dto.nutritioncategory.NutritionCategoryResponse;
import com.example.travel_backend.dto.turpacketcategory.TurPacketCategoryResponse;
import com.example.travel_backend.entity.Hotel;
import com.example.travel_backend.entity.TurPacket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurPacketResponse {
    private Long id;
    private String name;
    private String description;
    private String duration;
    private Long leaveDate;
    private Long returnDate;
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
    private List<HotelResponse> hotelResponses;

    public static TurPacketResponse toDto(TurPacket t, List<Hotel> hotels) {
        TurPacketResponse response = new TurPacketResponse();
        response.setId(t.getId());
        response.setName(t.getName());
        response.setDescription(t.getDescription());
        response.setDuration(t.getDuration());
        response.setLeaveDate(t.getLeaveDate());
        response.setReturnDate(t.getReturnDate());
        response.setPrice(t.getPrice());
        response.setDiscount(t.getDiscount());
        response.setPriceIncludes(t.getPriceIncludes());
        response.setPriceNotIncludes(t.getPriceNotIncludes());
        response.setInsurance(t.getInsurance());
        response.setVisa(t.isVisa());
        response.setNumberOfPeople(t.getNumberOfPeople());
        response.setRate(t.getRate());
        response.setActive(t.getActive());
        response.setCountryId(t.getId());
        response.setNutritionCategory(t.getNutritionCategory().stream().map(NutritionCategoryResponse::toDto).toList());
        response.setTurPacketCategory(t.getTurPacketCategory().stream().map(TurPacketCategoryResponse::toDto).toList());
        response.setHotelResponses(hotels.stream().map(HotelResponse::toDto).toList());
        return response;
    }


}
