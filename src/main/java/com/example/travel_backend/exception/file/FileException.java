package com.example.travel_backend.exception.file;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class FileException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.FILE_EXCEPTION;
    }
}
