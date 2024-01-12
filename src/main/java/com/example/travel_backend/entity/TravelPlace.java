package com.example.travel_backend.entity;

import com.example.travel_backend.base.BaseEntity;
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
    private Integer travelDay;
    private BigDecimal price;
    private Double rate;
    private Boolean active;
    @ManyToOne
    private Country country;
    @ManyToOne
    private FileItem travelPlaceImage;

}
