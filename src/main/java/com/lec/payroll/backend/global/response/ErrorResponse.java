package com.lec.payroll.backend.global.response;

import com.lec.payroll.backend.global.exception.ErrorCode;

public record ErrorResponse(
        ErrorCode errorCode
) {
}
