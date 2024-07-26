package com.lec.payroll.backend.global.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class DetailedErrorCode implements ErrorCode {

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
