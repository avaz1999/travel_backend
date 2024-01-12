package com.example.travel_backend.exception.base;

import java.util.Map;



public record ValidationErrorMessage(int code, String message, Map<String, Object> fields) {
    public ValidationErrorMessage(int code, String message, Map<String, Object> fields) {
        this.code = code;
        this.message = message;
        this.fields = fields;
    }
}
