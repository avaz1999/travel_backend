package com.example.travel_backend.exception.security;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class TokenInvalidException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.TOKEN_INVALID_EXCEPTION;
    }
}
