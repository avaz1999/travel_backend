package com.example.travel_backend.enums;

public enum ErrorCode {
    USER_NOT_FOUND(100),
    USER_ALREADY_EXISTS(101),
    VALIDATION_ERROR(102),
    NOT_ALLOWED(103),
    TYPE_MISMATCH_ERROR(104),
    COUNTRY_NOT_FOUND_EXCEPTION(200),
    TUR_PACKET_NOT_FOUND_EXCEPTION(300),
    NUTRITION_NOT_FOUND_EXCEPTION(400), TUR_PACKET_NOT_FOUND(301);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
