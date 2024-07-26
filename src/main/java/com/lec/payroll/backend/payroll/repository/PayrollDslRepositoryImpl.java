package com.lec.payroll.backend.payroll.repository;

import com.lec.payroll.backend.employee.model.Department;
import com.lec.payroll.backend.payroll.model.QPayroll;
import com.lec.payroll.backend.employee.model.QEmployee;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PayrollDslRepositoryImpl implements PayrollDslRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Integer getTotalPayrollsByDepartment(Department department) {

        QPayroll payroll = QPayroll.payroll;
        QEmployee employee = QEmployee.employee;

        return jpaQueryFactory
                .select(payroll.paycheck.sum())
                .from(payroll)
                .join(payroll.employee, employee)
                .where(employee.department.eq(department))
                .fetchOne();
    }
}
