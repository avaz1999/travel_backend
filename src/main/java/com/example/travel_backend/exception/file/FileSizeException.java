package com.example.travel_backend.exception.file;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class FileSizeException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.FILE_SIZE_EX;
    }
}
