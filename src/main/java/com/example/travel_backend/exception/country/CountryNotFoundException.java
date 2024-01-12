package com.example.travel_backend.exception.country;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class CountryNotFoundException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.COUNTRY_NOT_FOUND_EXCEPTION;
    }
}
