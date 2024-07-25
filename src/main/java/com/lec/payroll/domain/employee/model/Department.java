//package com.lec.payroll.domain.employee.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@Builder
//@AllArgsConstructor(access = AccessLevel.PACKAGE)
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Entity
//@Table(name = "departments")
//public class Department {
//    @Id
//    private Long id;
//
//    @Column(length = 50)
//    private String name;
//
//    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Employee> employees;
//
//}
