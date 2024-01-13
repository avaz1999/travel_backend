package com.example.travel_backend.entity;

import com.example.travel_backend.base.BaseEntity;
import com.example.travel_backend.dto.travel.TravelPlaceRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TravelPlace extends BaseEntity {
    private String name;
    private String description;
    private Integer travelDay;
    private BigDecimal price;
    private Double rate;
    private Boolean active;
    @ManyToOne
    private Country country;
    @ManyToOne
    private FileItem travelPlaceImage;

    public static TravelPlace toEntity(TravelPlaceRequest request, Country country) {
        TravelPlace travelPlace = new TravelPlace();
        travelPlace.setName(request.getName());
        travelPlace.setDescription(request.getDescription());
        travelPlace.setTravelDay(request.getTravelDay());
        travelPlace.setPrice(request.getPrice());
        travelPlace.setActive(true);
        travelPlace.setCountry(country);
        return travelPlace;
    }
}
