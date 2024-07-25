package com.lec.payroll.domain.payroll.model;

import com.lec.payroll.domain.employee.model.Employee;
import com.lec.payroll.domain.global.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "payrolls")
public class Payroll extends BaseEntity {
    @Id
    private Long id;

    private Long paycheck;

    @OneToOne
    private Employee employee;

}
