package com.example.travel_backend.dto.travel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurPacketRequest {
    @NotBlank(message = "Can't be left blank")
    private String name;
    @NotBlank(message = "Can't be left blank")
    private String description;
    @NotBlank(message = "Can't be left blank")
    private String duration;
    @NotBlank(message = "Can't be left blank")
    private Date leaveDate;
    @NotBlank(message = "Can't be left blank")
    private Date returnDate;
    @NotBlank(message = "Can't be left blank")
    private BigDecimal price;
    @NotBlank(message = "Can't be left blank")
    private Double discount;
    @NotBlank(message = "Can't be left blank")
    private String priceIncludes;
    @NotBlank(message = "Can't be left blank")
    private String priceNotIncludes;
    @NotBlank(message = "Can't be left blank")
    private String insurance;
    @NotBlank(message = "Can't be left blank")
    private boolean visa;
    @NotBlank(message = "Can't be left blank")
    private Byte numberOfPeople;
    @NotBlank(message = "Can't be left blank")
    private Boolean active;
    @NotBlank(message = "Can't be left blank")
    private List<Long> nutritionCategoryId;
    @NotBlank(message = "Can't be left blank")
    private List<Long> turPacketCategoryId;
}
