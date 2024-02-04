package com.example.travel_backend.dto.nutritioncategory;

import com.example.travel_backend.entity.NutritionCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NutritionCategoryRequest {
    @NotBlank(message = "Can't be left blank")
    private String name;

    public static NutritionCategoryRequest toDto(NutritionCategory nutritionCategory) {
        return new NutritionCategoryRequest(nutritionCategory.getName());
    }
}
