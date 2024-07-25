package com.lec.payroll.controller;

import com.lec.payroll.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
}
