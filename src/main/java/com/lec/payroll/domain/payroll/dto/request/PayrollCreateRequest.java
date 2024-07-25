package com.lec.payroll.domain.payroll.dto.request;

import jakarta.validation.constraints.NotNull;

public record PayrollCreateRequest(
        @NotNull Long employeeId,
        @NotNull Integer paycheck
) {
}
