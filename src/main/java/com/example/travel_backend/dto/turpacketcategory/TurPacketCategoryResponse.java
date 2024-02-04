package com.example.travel_backend.dto.turpacketcategory;

import com.example.travel_backend.entity.TurPacketCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurPacketCategoryResponse {
    private Long id;
    private String name;

    public static TurPacketCategoryResponse toDto(TurPacketCategory t) {
        TurPacketCategoryResponse response = new TurPacketCategoryResponse();
        response.setId(t.getId());
        response.setName(t.getName());
        return response;
    }
}
