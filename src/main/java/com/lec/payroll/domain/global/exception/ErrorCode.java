package com.lec.payroll.domain.global.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    public Integer getCode();
    public String getMessage();
    public HttpStatus getHttpStatus();
}
