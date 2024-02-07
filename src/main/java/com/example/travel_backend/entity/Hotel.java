package com.example.travel_backend.entity;

import com.example.travel_backend.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Hotel extends BaseEntity {
    @Column(nullable = false)
    private String name;
    private Double rate;
    private BigDecimal price;
    private String description;
    private Double percent;
    private Boolean active;
    @ManyToOne
    private TurPacket travelPlace;
    @ManyToOne
    private FileItem hotelImage;
}
