package com.example.travel_backend.exception.user;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class UserNotFoundException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.USER_NOT_FOUND;
    }
}
