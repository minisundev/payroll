package com.lec.payroll.domain.payroll.model;

import com.lec.payroll.domain.employee.model.Department;
import com.lec.payroll.domain.employee.model.Employee;
import com.lec.payroll.domain.employee.model.Position;
import com.lec.payroll.domain.global.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "payrolls")
public class Payroll extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer paycheck;

    @OneToOne
    private Employee employee;
}
