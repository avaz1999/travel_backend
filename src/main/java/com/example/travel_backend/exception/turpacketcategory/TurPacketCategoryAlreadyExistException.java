package com.example.travel_backend.exception.turpacketcategory;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class TurPacketCategoryAlreadyExistException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.TUR_PACKET_CATEGORY_ALREADY_EXCEPTION;
    }
}
