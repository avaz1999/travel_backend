package com.example.travel_backend.exception.turpacket;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class TurPacketNotFoundException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.TUR_PACKET_NOT_FOUND ;
    }
}
