package com.example.travel_backend.enums;

public enum ErrorCode {
    USER_NOT_FOUND(100), USER_ALREDY_EXISTS(101);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
