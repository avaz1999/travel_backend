package com.example.travel_backend.entity;

import com.example.travel_backend.base.BaseEntity;
import com.example.travel_backend.dto.travel.TurPacketRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TurPacket extends BaseEntity {
    private String name;
    private String description;
    private String duration;
    private Date leaveDate;
    private Date returnDate;
    private BigDecimal price;
    private Double discount;
    private String priceIncludes;
    private String priceNotIncludes;
    private String insurance;
    private boolean visa;
    private Byte numberOfPeople;
    private Double rate;
    private Boolean active;
    @ManyToOne
    private Country country;
    @ManyToMany
    @JoinTable(
            name = "tur_packets_image",
            joinColumns = @JoinColumn(name = "tur_packet_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<FileItem> travelPlaceImage;
    @ManyToMany
    @JoinTable(
            name = "tur_packet_nutrition_category",
            joinColumns = @JoinColumn(name = "tur_packet_id"),
            inverseJoinColumns = @JoinColumn(name = "nutrition_category")
    )
    private List<NutritionCategory> nutritionCategory;
    @ManyToMany
    @JoinTable(
            name = "tur_packet_category",
            joinColumns = @JoinColumn(name = "tur_packet_id"),
            inverseJoinColumns = @JoinColumn(name = "tur_pcaket_category_id")
    )
    private List<TurPacketCategory> turPacketCategory;

    public static TurPacket toEntity(TurPacketRequest request, Country country) {
        TurPacket travelPlace = new TurPacket();
        travelPlace.setName(request.getName());
        travelPlace.setDescription(request.getDescription());
        travelPlace.setPrice(request.getPrice());
        travelPlace.setActive(true);
        travelPlace.setCountry(country);
        return travelPlace;
    }
}
