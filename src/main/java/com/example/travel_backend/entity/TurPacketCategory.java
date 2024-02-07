package com.example.travel_backend.entity;

import com.example.travel_backend.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TurPacketCategory extends BaseEntity {
    private String name;
    @OneToOne
    private FileItem image;

    public TurPacketCategory(String name) {
        this.name = name;
    }
}
