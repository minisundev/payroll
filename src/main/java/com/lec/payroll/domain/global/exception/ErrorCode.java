package com.lec.payroll.domain.global.exception;

public interface ErrorCode {
    public String getCode();
    public String getMessage();
    public String getHttpStatus();
}
