package com.example.travel_backend.dto.nutritioncategory;

import com.example.travel_backend.entity.NutritionCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NutritionCategoryResponse {
    private Long id;
    private String name;
    public static NutritionCategoryResponse toDto(NutritionCategory n) {
        NutritionCategoryResponse response = new NutritionCategoryResponse();
        response.setId(n.getId());
        response.setName(n.getName());
        return response;
    }
}
