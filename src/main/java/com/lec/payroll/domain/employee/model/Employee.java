package com.lec.payroll.domain.employee.model;

import com.lec.payroll.domain.global.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer salary;

    @Column
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
}
