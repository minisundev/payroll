package com.lec.payroll.backend.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
        Integer code,
        String message,
        T data
) {
}
