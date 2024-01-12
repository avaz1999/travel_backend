package com.example.travel_backend.dto.country;

import com.example.travel_backend.dto.travel.TravelPlaceForCountry;
import com.example.travel_backend.entity.Country;
import com.example.travel_backend.entity.TravelPlace;
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
    private List<TravelPlaceForCountry> travelPlace;

    public static GetOneCountryResponse toDto(Country country, List<TravelPlace> travelPlaceList) {
        GetOneCountryResponse response = new GetOneCountryResponse();
        response.setId(country.getId());
        response.setName(country.getName());
        response.setDescription(country.getDescription());
        response.setTravelPlace(travelPlaceList.stream().map(TravelPlaceForCountry::toDtoForCountry).toList());
        return response;
    }
}
