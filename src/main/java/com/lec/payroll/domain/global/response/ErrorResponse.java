package com.lec.payroll.domain.global.response;

import com.lec.payroll.domain.global.exception.ErrorCode;

public record ErrorResponse(
        ErrorCode errorCode
) {
}
