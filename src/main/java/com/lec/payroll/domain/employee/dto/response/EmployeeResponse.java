package com.lec.payroll.domain.employee.dto.response;

import com.lec.payroll.domain.employee.model.Department;
import com.lec.payroll.domain.employee.model.Position;
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
