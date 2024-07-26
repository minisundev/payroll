package com.lec.payroll.backend.payroll.repository;


import com.lec.payroll.backend.employee.model.Department;
import com.lec.payroll.backend.payroll.model.Payroll;

import java.util.List;

public interface PayrollDslRepository {

    public Integer getTotalPayrollsByDepartment(Department department);

    public List<Payroll> getAllPayrolls(int page, int size);
}
