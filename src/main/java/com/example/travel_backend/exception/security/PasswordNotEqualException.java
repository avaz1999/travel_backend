package com.example.travel_backend.exception.security;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class PasswordNotEqualException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.NOT_EQUAL_PASSWORD;
    }
}
