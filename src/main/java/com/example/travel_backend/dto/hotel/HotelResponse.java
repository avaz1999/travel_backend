package com.example.travel_backend.dto.hotel;

import com.example.travel_backend.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotelResponse {
    private Long id;
    private String name;
    private Double rate;
    private BigDecimal price;
    private String description;
    private Double percent;
    private Boolean active;

    public static HotelResponse toDto(Hotel hotel) {
        HotelResponse response = new HotelResponse();
        response.setId(hotel.getId());
        response.setName(hotel.getName());
        response.setRate(hotel.getRate());
        response.setPercent(hotel.getPercent());
        response.setDescription(hotel.getDescription());
        response.setPercent(hotel.getPercent());
        response.setActive(hotel.getActive());
        return response;
    }
}
