package com.example.travel_backend.dto.country;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountryRequest {
    private Long id;
    @NotBlank(message = "Can't be left blank")
    private String name;
    @NotBlank(message = "Can't be left blank")
    private String description;
}
