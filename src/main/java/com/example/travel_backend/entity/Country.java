package com.example.travel_backend.entity;

import com.example.travel_backend.base.BaseEntity;
import com.example.travel_backend.dto.country.CountryEditRequest;
import com.example.travel_backend.dto.country.CountryRequest;
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
    @ManyToOne
    private FileItem countryImage;

    public static Country toEntity(CountryRequest request) {
        Country country = new Country();
        country.setName(request.getName());
        country.setDescription(request.getDescription());
        return country;
    }

    public static Country edit(Country country, CountryEditRequest request) {
        country.setName(request.getName() != null ? request.getName() : country.getName());
        country.setDescription(request.getDescription() != null ? request.getDescription() : country.getDescription());
        return country;
    }
}
