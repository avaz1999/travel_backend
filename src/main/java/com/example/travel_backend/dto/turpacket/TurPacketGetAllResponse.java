package com.example.travel_backend.dto.turpacket;

import com.example.travel_backend.dto.nutritioncategory.NutritionCategoryResponse;
import com.example.travel_backend.entity.TurPacket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurPacketGetAllResponse {
    private Long id;
    private String name;
    private String duration;
    private Long leaveDate;
    private Long returnDate;
    private BigDecimal price;
    private Double discount;
    private Double rate;
    private List<NutritionCategoryResponse> nutritionCategory;

    public static TurPacketGetAllResponse toDtoGetAll(TurPacket turPacket) {
        TurPacketGetAllResponse response = new TurPacketGetAllResponse();
        response.setId(turPacket.getId());
        response.setName(turPacket.getName());
        response.setDuration(turPacket.getDuration());
        response.setLeaveDate(turPacket.getLeaveDate());
        response.setReturnDate(turPacket.getReturnDate());
        response.setPrice(turPacket.getPrice());
        response.setDiscount(turPacket.getDiscount());
        response.setRate(turPacket.getRate());
        response.setNutritionCategory(turPacket.getNutritionCategory().stream().map(NutritionCategoryResponse::toDto).toList());
        return response;
    }
}
