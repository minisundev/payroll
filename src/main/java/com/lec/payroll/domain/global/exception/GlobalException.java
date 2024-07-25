package com.lec.payroll.domain.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private ErrorCode ErrorCode;
}
