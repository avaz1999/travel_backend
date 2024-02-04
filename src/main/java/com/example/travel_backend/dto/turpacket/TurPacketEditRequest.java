package com.example.travel_backend.dto.turpacket;

import com.example.travel_backend.dto.hotel.HotelResponse;
import com.example.travel_backend.dto.nutritioncategory.NutritionCategoryResponse;
import com.example.travel_backend.dto.turpacketcategory.TurPacketCategoryResponse;
import com.example.travel_backend.entity.Hotel;
import com.example.travel_backend.entity.NutritionCategory;
import com.example.travel_backend.entity.TurPacket;
import com.example.travel_backend.entity.TurPacketCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurPacketEditRequest {
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
    private Boolean visa;
    private Byte numberOfPeople;
    private Double rate;
    private Boolean active;
    private Long countryId;
    private List<NutritionCategoryResponse> nutritionCategory;
    private List<TurPacketCategoryResponse> turPacketCategory;
    private List<HotelResponse> hotelResponses;

    public static TurPacket edit(TurPacket tp, TurPacketEditRequest r, List<NutritionCategory> nT, List<TurPacketCategory> tC) {
        tp.setName(r.getName() != null ? r.getName() : tp.getName());
        tp.setDescription(r.getDescription() != null ? r.getDescription() : tp.getDescription());
        tp.setDuration(r.getDuration() != null ? r.getDuration() : tp.getDuration());
        tp.setLeaveDate(r.getLeaveDate() != null ? r.getLeaveDate() : tp.getLeaveDate());
        tp.setReturnDate(r.getReturnDate() != null ? r.getReturnDate() : tp.getReturnDate());
        tp.setPrice(r.getPrice() != null ? r.getPrice() : tp.getPrice());
        tp.setDiscount(r.getDiscount() != null ? r.getDiscount() : tp.getDiscount());
        tp.setPriceIncludes(r.getPriceIncludes() != null ? r.getPriceIncludes() : tp.getPriceIncludes());
        tp.setPriceNotIncludes(r.getPriceNotIncludes() != null ? r.getPriceNotIncludes() : tp.getPriceNotIncludes());
        tp.setInsurance(r.getInsurance() != null ? r.getInsurance() : tp.getInsurance());
        tp.setVisa(r.getVisa() != null ? r.getVisa() : tp.isVisa());
        tp.setNumberOfPeople(r.getNumberOfPeople() != null ? r.getNumberOfPeople():tp.getNumberOfPeople());
        tp.setActive(r.getActive() != null ? r.getActive() : tp.getActive());
        tp.setNutritionCategory(!nT.isEmpty() ? nT : tp.getNutritionCategory());
        tp.setTurPacketCategory(!tC.isEmpty() ? tC : tp.getTurPacketCategory());
        return tp;
    }
}
