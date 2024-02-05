package com.example.travel_backend.exception.file;

import com.example.travel_backend.enums.ErrorCode;
import com.example.travel_backend.exception.base.TravelException;

public class FileCategoryNotFoundException extends TravelException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.FILE_CATEGORY_NOT_FOUND;
    }
}
