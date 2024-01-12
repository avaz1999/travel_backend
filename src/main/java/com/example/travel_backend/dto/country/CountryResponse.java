package com.example.travel_backend.dto.country;

import com.example.travel_backend.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountryResponse {
    private Long id;
    private String name;
    private String description;

    public static CountryResponse toDto(Country country) {
        CountryResponse response = new CountryResponse();
        response.setId(country.getId());
        response.setName(country.getName());
        response.setDescription(country.getDescription());
        return response;
    }
}
