package com.lec.payroll.backend.payroll.model;

import com.lec.payroll.backend.employee.model.Employee;
import com.lec.payroll.backend.global.model.BaseEntity;
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
