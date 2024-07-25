package com.lec.payroll.domain.employee.controller;

import com.lec.payroll.domain.employee.dto.request.EmployeeCreateRequest;
import com.lec.payroll.domain.employee.service.EmployeeService;
import com.lec.payroll.domain.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<ApiResponse<Void>> addEmployee(@Valid @RequestBody EmployeeCreateRequest request) {
        return new ResponseEntity(
                new ApiResponse<Void>(
                        null,
                        employeeService.addEmployee(request),
                        null),
                HttpStatus.CREATED);
    }
}
