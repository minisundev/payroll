package com.lec.payroll.backend.employee.controller;

import com.lec.payroll.backend.employee.dto.request.EmployeeCreateRequest;
import com.lec.payroll.backend.employee.dto.response.EmployeeResponse;
import com.lec.payroll.backend.employee.model.Department;
import com.lec.payroll.backend.employee.model.Position;
import com.lec.payroll.backend.employee.service.EmployeeService;
import com.lec.payroll.backend.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/positions")
    public ApiResponse<List<Position>> getPositions() {
        List<Position> results = employeeService.getPositions();
        ApiResponse<List<Position>> response
                = new ApiResponse<>(null,null,results);
        return response;
    }

    @GetMapping("/departments")
    public ApiResponse<List<Department>> getDepartments() {
        List<Department> results = employeeService.getDepartments();
        ApiResponse<List<Department>> response
                = new ApiResponse<>(null,null,results);
        return response;
    }
}
