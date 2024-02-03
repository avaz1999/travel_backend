package com.example.travel_backend.dto.travel;

import com.example.travel_backend.dto.hotel.HotelResponse;
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
public class TravelPlaceWithHotelResponse {
    private Long id;
    private String name;
    private Integer travelDay;
    private BigDecimal price;
    private Double rate;
    private Boolean active;
    private List<HotelResponse> hotelResponses;

    public static TravelPlaceWithHotelResponse toDtoWithHotel(TurPacket tp, List<Hotel> h) {
        TravelPlaceWithHotelResponse response = new TravelPlaceWithHotelResponse();
        response.setId(tp.getId());
        response.setName(tp.getName());
        response.setPrice(tp.getPrice());
        response.setRate(tp.getRate());
        response.setActive(tp.getActive());
        response.setHotelResponses(h.stream().map(HotelResponse::toDto).toList());
        return response;
    }
}
