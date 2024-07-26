package com.lec.payroll.backend.payroll.dto.response;

import com.lec.payroll.backend.employee.dto.response.EmployeeResponse;

public record PayrollResponse(
    Long id,
    Integer paycheck,
    EmployeeResponse employee
) {
}
