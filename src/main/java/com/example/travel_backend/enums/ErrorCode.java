package com.example.travel_backend.enums;

public enum ErrorCode {
    USER_NOT_FOUND(100),
    USER_ALREADY_EXISTS(101),
    VALIDATION_ERROR(102),
    NOT_ALLOWED(103),
    TYPE_MISMATCH_ERROR(104),
    BAD_CREDENTIALS_EXCEPTION(105),
    GRANT_TYPE_AND_AUTH_NOT_COMPATIBLE(106),
    TOKEN_INVALID_EXCEPTION(107),
    UNSUPPORTED_GRANT_TYPE(108),
    COUNTRY_NOT_FOUND_EXCEPTION(200),
    TUR_PACKET_NOT_FOUND_EXCEPTION(300),
    NUTRITION_NOT_FOUND_EXCEPTION(400), TUR_PACKET_NOT_FOUND(301),
    TUR_PACKET_CATEGORY_ALREADY_EXCEPTION(350),
    FILE_EXCEPTION(450), FILE_FORMAT_EXCEPTION(451), SAVE_FILE_NOT_CREATED(452), FILE_SIZE_EX(453), FILE_CATEGORY_NOT_FOUND(454), NOT_EQUAL_PASSWORD(109);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
