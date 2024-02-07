package com.example.travel_backend.exception.user;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class GrantTypeAndAuthNotCompatibleException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.GRANT_TYPE_AND_AUTH_NOT_COMPATIBLE;
    }
}
