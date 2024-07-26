package com.lec.payroll.backend.employee.dto.response;

import com.lec.payroll.backend.employee.model.Department;
import com.lec.payroll.backend.employee.model.Position;
import lombok.Builder;

@Builder
public record EmployeeResponse(
        Long id,
        String name,
        Integer salary,
        Position position,
        Department department
) {
}
