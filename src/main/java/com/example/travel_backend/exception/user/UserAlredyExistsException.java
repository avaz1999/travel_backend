package com.example.travel_backend.exception.user;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.TravelException;

public class UserAlredyExistsException extends TravelException {

    @Override
    public ErrorCode errorType() {
        return ErrorCode.USER_ALREDY_EXISTS;
    }
}
