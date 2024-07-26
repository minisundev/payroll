package com.lec.payroll.domain.employee.controller;

import com.lec.payroll.domain.employee.dto.request.EmployeeCreateRequest;
import com.lec.payroll.domain.employee.dto.response.EmployeeResponse;
import com.lec.payroll.domain.employee.service.EmployeeService;
import com.lec.payroll.domain.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("")
    public ApiResponse<Void> addEmployee(@Valid @RequestBody EmployeeCreateRequest request) {
        employeeService.addEmployee(request);
        String msg = "Employee added successfully";
        ApiResponse<Void> response = new ApiResponse<>(null,msg,null);
        return response;
    }

    @GetMapping("")
    public ApiResponse<List<EmployeeResponse>> getEmployees() {
        List<EmployeeResponse> results = employeeService.getEmployees();
        ApiResponse<List<EmployeeResponse>> response
                = new ApiResponse<>(null,null,results);
        return response;
    }
}
