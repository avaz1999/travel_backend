package com.example.travel_backend.dto.travel;

import com.example.travel_backend.entity.TravelPlace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravelPlaceForCountry {
    private Long id;
    private String name;
    private Integer travelDay;
    private BigDecimal price;
    private Double rate;
    private Boolean active;

    public static TravelPlaceForCountry toDtoForCountry(TravelPlace travelPlace) {
        TravelPlaceForCountry placeForCountry = new TravelPlaceForCountry();
        placeForCountry.setId(travelPlace.getId());
        placeForCountry.setName(travelPlace.getName());
        placeForCountry.setTravelDay(travelPlace.getTravelDay());
        placeForCountry.setPrice(travelPlace.getPrice());
        placeForCountry.setRate(travelPlace.getRate());
        placeForCountry.setActive(travelPlace.getActive());
        return placeForCountry;
    }
}
