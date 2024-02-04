package com.example.travel_backend.exception.ntrition;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NutritionCategoryNotFoundException extends TravelException {
    private Long id;
    @Override
    public ErrorCode errorType() {
        return ErrorCode.NUTRITION_NOT_FOUND_EXCEPTION;
    }
}
