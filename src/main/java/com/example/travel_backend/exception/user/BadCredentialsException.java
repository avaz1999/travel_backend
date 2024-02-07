package com.example.travel_backend.exception.user;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class BadCredentialsException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.BAD_CREDENTIALS_EXCEPTION;
    }
}
