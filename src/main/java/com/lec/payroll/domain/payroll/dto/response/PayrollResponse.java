package com.lec.payroll.domain.payroll.dto.response;

import com.lec.payroll.domain.employee.dto.response.EmployeeResponse;

public record PayrollResponse(
    Long id,
    Integer paycheck,
    EmployeeResponse employee
) {
}
