package com.lec.payroll.domain.payroll.repository;


import com.lec.payroll.domain.employee.model.Department;

public interface PayrollDslRepository {

    public Integer getTotalPayrollsByDepartment(Department department);
}
