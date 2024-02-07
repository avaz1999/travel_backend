package com.example.travel_backend.entity;

import com.example.travel_backend.base.BaseEntity;
import com.example.travel_backend.dto.turpacket.TurPacketRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Long leaveDate;
    private Long returnDate;
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
            name = "tur_packets_category",
            joinColumns = @JoinColumn(name = "tur_packet_id"),
            inverseJoinColumns = @JoinColumn(name = "tur_pcaket_category_id")
    )
    private List<TurPacketCategory> turPacketCategory;

    public static TurPacket toEntity(TurPacketRequest request, Country country, List<NutritionCategory> nutritionCategory, List<TurPacketCategory> turPacketCategory) {
        TurPacket travelPlace = new TurPacket();
        travelPlace.setName(request.getName());
        travelPlace.setDescription(request.getDescription());
        travelPlace.setDuration(request.getDuration());
        travelPlace.setLeaveDate(request.getLeaveDate());
        travelPlace.setReturnDate(request.getReturnDate());
        travelPlace.setPrice(request.getPrice());
        travelPlace.setDiscount(request.getDiscount());
        travelPlace.setPriceIncludes(request.getPriceIncludes());
        travelPlace.setPriceNotIncludes(request.getPriceNotIncludes());
        travelPlace.setInsurance(request.getInsurance());
        travelPlace.setVisa(request.isVisa());
        travelPlace.setNumberOfPeople(request.getNumberOfPeople());
        travelPlace.setRate(0.0);
        travelPlace.setActive(request.getActive());
        travelPlace.setCountry(country);
        travelPlace.setNutritionCategory(nutritionCategory);
        travelPlace.setTurPacketCategory(turPacketCategory);
        return travelPlace;
    }
}
