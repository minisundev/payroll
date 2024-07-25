package com.lec.payroll.domain.payroll.repository;

import com.lec.payroll.domain.employee.model.Department;
import com.lec.payroll.domain.payroll.dto.response.DepartmentPayrollResponse;
import com.lec.payroll.domain.payroll.model.QPayroll;
import com.lec.payroll.domain.employee.model.QEmployee;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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
