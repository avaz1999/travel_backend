package com.example.travel_backend.dto.travel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravelPlaceRequest {
    @NotBlank(message = "Can't be left blank")
    private String name;
    @NotBlank(message = "Can't be left blank")
    private String description;
    @NotBlank(message = "Can't be left blank")
    private Integer travelDay;
    @NotBlank(message = "Can't be left blank")
    private BigDecimal price;
    @NotBlank(message = "Can't be left blank")
    private Long countryId;
    private Boolean active;
}
