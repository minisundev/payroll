package com.lec.payroll.exception;

public interface ErrorCode {
    public String getCode();
    public String getMessage();
    public String getHttpStatus();
}
