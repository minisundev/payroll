package com.lec.payroll.backend.payroll.repository;


import com.lec.payroll.backend.employee.model.Department;

public interface PayrollDslRepository {

    public Integer getTotalPayrollsByDepartment(Department department);
}
