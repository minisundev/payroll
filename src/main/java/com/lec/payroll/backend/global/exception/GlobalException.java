package com.lec.payroll.backend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private ErrorCode ErrorCode;
}
