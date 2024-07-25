package com.lec.payroll.domain.payroll.controller;

import com.lec.payroll.domain.payroll.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/payroll")
public class PayRollController {
    private final PayrollService payrollService;
}
