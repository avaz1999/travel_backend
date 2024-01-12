package com.example.travel_backend.exception.base;

import com.example.travel_backend.dto.BaseMessage;
import com.example.travel_backend.enums.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@NoArgsConstructor
@Getter
@Setter
public abstract class TravelException extends RuntimeException{
    private String message;
    private Integer code;

    public TravelException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }
    public abstract ErrorCode errorType();
    protected Object[] getErrorMessageArguments() {
        return null;
    }

    public BaseMessage getErrorMessage(ResourceBundleMessageSource errorMessageSource) {
        return new BaseMessage(
                errorType().getCode(),
                errorMessageSource.getMessage(
                        errorType().toString(),
                        getErrorMessageArguments(),
                        new Locale(LocaleContextHolder.getLocale().getLanguage())
                )
        );
    }

}

