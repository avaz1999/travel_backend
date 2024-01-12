package com.example.travel_backend.dto.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountryRequest {
    private Long id;
    private String name;
    private String description;
}
