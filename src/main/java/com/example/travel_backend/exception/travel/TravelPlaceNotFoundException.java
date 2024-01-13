package com.example.travel_backend.exception.travel;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class TravelPlaceNotFoundException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.TRAVEL_NOT_FOUND_EXCEPTION;
    }
}
