package com.lec.payroll.domain.payroll.dto.response;

import lombok.Builder;

@Builder
public record DepartmentPayrollResponse(
        String departmentName,
        Integer totalPaycheck
) {
}
