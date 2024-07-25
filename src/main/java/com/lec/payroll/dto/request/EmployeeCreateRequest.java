package com.lec.payroll.dto.request;

import com.lec.payroll.model.Position;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeCreateRequest(
        @NotBlank String name,
        @NotNull Integer salary,
        @NotNull Position position,
        @NotNull Long departmentId
) {
}
