package com.example.travel_backend.entity;

import com.example.travel_backend.base.BaseEntity;
import jakarta.persistence.ElementCollection;
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
public class Country extends BaseEntity {
    private String name;
    private String description;
    private Integer travelDay;
    private BigDecimal price;
    private Double rate;
    private Boolean active;
    @ManyToOne
    private FileItem countryImage;

}
