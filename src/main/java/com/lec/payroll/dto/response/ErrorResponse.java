package com.lec.payroll.dto.response;

import com.lec.payroll.exception.ErrorCode;

public record ErrorResponse(
        ErrorCode errorCode
) {
}
