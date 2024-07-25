package com.lec.payroll;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestPayrollApplication {

    public static void main(String[] args) {
        SpringApplication.from(PayrollApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
