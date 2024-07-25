package com.lec.payroll.domain.employee.dto.response;

import com.lec.payroll.domain.employee.model.Department;
import com.lec.payroll.domain.employee.model.Position;

public record EmployeeResponse(
        Long id,
        String name,
        Integer salary,
        Position position,
        Department department
) {
}
