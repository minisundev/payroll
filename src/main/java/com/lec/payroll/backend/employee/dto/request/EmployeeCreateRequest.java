package com.lec.payroll.backend.employee.dto.request;

import com.lec.payroll.backend.employee.model.Department;
import com.lec.payroll.backend.employee.model.Position;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeCreateRequest(
        @NotBlank String name,
        @NotNull Integer salary,
        @NotNull Position position,
        @NotNull Department department
) {
}
