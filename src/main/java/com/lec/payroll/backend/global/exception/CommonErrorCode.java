package com.lec.payroll.backend.global.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode{


    NOT_FOUND(4000,"No data available for the requested id", HttpStatus.NOT_FOUND);

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;
}
