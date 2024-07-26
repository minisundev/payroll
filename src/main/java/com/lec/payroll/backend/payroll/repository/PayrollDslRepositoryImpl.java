package com.lec.payroll.backend.payroll.repository;

import com.lec.payroll.backend.employee.model.Department;
import com.lec.payroll.backend.payroll.model.Payroll;
import com.lec.payroll.backend.payroll.model.QPayroll;
import com.lec.payroll.backend.employee.model.QEmployee;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public List<Payroll> getAllPayrolls(int page, int size) {
        QPayroll payroll = QPayroll.payroll;
        int offset = page*size;

        List<Payroll> payrolls = jpaQueryFactory
                .selectFrom(payroll)
                .offset(offset)
                .limit(size)
                .fetch();

        return payrolls;
    }
}
