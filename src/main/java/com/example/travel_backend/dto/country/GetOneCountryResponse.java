package com.example.travel_backend.dto.country;

import com.example.travel_backend.dto.turpacket.TurPacketGetAllResponse;
import com.example.travel_backend.dto.turpacket.TurPacketResponse;
import com.example.travel_backend.entity.Country;
import com.example.travel_backend.entity.TurPacket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetOneCountryResponse {
    private Long id;
    private String name;
    private String description;
    private List<TurPacketGetAllResponse> travelPlace;

    public static GetOneCountryResponse toDto(Country country, List<TurPacket> travelPlaceList) {
        GetOneCountryResponse response = new GetOneCountryResponse();
        response.setId(country.getId());
        response.setName(country.getName());
        response.setDescription(country.getDescription());
        response.setTravelPlace(travelPlaceList.stream().map(TurPacketGetAllResponse::toDtoGetAll).toList());
        return response;
    }
}
