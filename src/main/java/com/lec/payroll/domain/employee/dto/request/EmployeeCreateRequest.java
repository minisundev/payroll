package com.lec.payroll.domain.employee.dto.request;

import com.lec.payroll.domain.employee.model.Department;
import com.lec.payroll.domain.employee.model.Position;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeCreateRequest(
        @NotBlank String name,
        @NotNull Integer salary,
        @NotNull Position position,
        @NotNull Department department
) {
}
