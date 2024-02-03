package com.example.travel_backend.dto.travel;

import com.example.travel_backend.entity.TurPacket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurPacketEditRequest {
    private Long id;
    private String name;
    private String description;
    private Integer travelDay;
    private BigDecimal price;
    private Long countryId;
    private Boolean active;
    public static TurPacket edit(TurPacket travelPlace, TurPacketEditRequest request) {
        travelPlace.setName(request.getName() != null ? request.getName() : travelPlace.getName());
        travelPlace.setDescription(request.getDescription() != null? request.getDescription() : travelPlace.getDescription());
        travelPlace.setTravelDay(request.getTravelDay() != null ? request.getTravelDay() : travelPlace.getTravelDay());
        travelPlace.setPrice(request.getPrice() != null ? request.getPrice() : travelPlace.getPrice());
        travelPlace.setActive(request.getActive() != null ? request.getActive() : travelPlace.getActive());
        return travelPlace;
    }
}
