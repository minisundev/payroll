package com.lec.payroll.backend.payroll.dto.response;

import lombok.Builder;

@Builder
public record DepartmentPayrollResponse(
        String departmentName,
        Integer totalPaycheck
) {
}
