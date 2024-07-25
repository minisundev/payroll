package com.lec.payroll.domain.payroll.dto.request;

import com.lec.payroll.domain.employee.model.Department;
import com.lec.payroll.domain.employee.model.Position;
import jakarta.validation.constraints.NotNull;

public record PayrollCreateRequest(
        @NotNull Long employeeId,
        @NotNull Position position,
        @NotNull Department department,
        @NotNull Integer paycheck
) {
}
