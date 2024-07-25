package com.lec.payroll.domain.payroll.service;

import com.lec.payroll.domain.payroll.repository.PayrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PayrollService {
    private final PayrollRepository payrollRepository;
}
