package com.example.travel_backend.dto.travel;

import com.example.travel_backend.entity.Hotel;
import com.example.travel_backend.entity.TravelPlace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravelPlaceResponse {
    private Long id;
    private String name;
    private String description;
    private Integer travelDay;
    private BigDecimal price;
    private Double rate;
    private Boolean active;

    public static TravelPlaceResponse toDto(TravelPlace travelPlace) {
        TravelPlaceResponse response = new TravelPlaceResponse();
        response.setId(travelPlace.getId());
        response.setName(travelPlace.getName());
        response.setDescription(travelPlace.getDescription());
        response.setTravelDay(travelPlace.getTravelDay());
        response.setPrice(travelPlace.getPrice());
        response.setRate(travelPlace.getRate());
        response.setActive(travelPlace.getActive());
        return response;
    }


}