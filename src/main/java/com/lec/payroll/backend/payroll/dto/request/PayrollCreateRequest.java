package com.lec.payroll.backend.payroll.dto.request;

import jakarta.validation.constraints.NotNull;

public record PayrollCreateRequest(
        @NotNull Long employeeId,
        @NotNull Integer paycheck
) {
}
