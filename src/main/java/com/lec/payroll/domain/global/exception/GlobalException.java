package com.lec.payroll.domain.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GlobalException extends Exception {
    private ErrorCode errorCode;
}
