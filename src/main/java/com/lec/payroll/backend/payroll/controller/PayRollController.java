package com.lec.payroll.backend.payroll.controller;

import com.lec.payroll.backend.employee.model.Department;
import com.lec.payroll.backend.global.response.ApiResponse;
import com.lec.payroll.backend.payroll.dto.request.PayrollCreateRequest;
import com.lec.payroll.backend.payroll.dto.response.DepartmentPayrollResponse;
import com.lec.payroll.backend.payroll.dto.response.PayrollResponse;
import com.lec.payroll.backend.payroll.service.PayrollService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PayRollController {
    private final PayrollService payrollService;

    @PostMapping("/payroll")
    public ResponseEntity<ApiResponse<Void>> addPayroll(
            @Valid @RequestBody PayrollCreateRequest request
    ) {
        payrollService.addPayroll(request);
        String msg = "Payroll added successfully";
        ApiResponse<Void> response = new ApiResponse<Void>(null, msg, null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/payrolls")
    public ResponseEntity<ApiResponse<List<PayrollResponse>>> getPayrolls(
            @RequestParam(name = "page") int page,
            @RequestParam(name = "size") int size
    ) {
        List<PayrollResponse> result = payrollService.getPayrolls(page,size);
        ApiResponse<List<PayrollResponse>> response
                = new ApiResponse<>(null,null,result);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/payroll/{payrollId}")
    public ResponseEntity<ApiResponse<PayrollResponse>> getPayroll(
            @PathVariable(name = "payrollId") Long payrollId
    ) {
        PayrollResponse result = payrollService.getPayroll(payrollId);
        ApiResponse<PayrollResponse> response
                = new ApiResponse<>(null,null,result);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/payroll/department")
    public ResponseEntity<ApiResponse<DepartmentPayrollResponse>> getTotalPayrollByDepartment(
            @Valid @RequestParam(name = "department") Department department
            ) {
        DepartmentPayrollResponse result = payrollService.getTotalPayrollByDepartment(department);
        ApiResponse<DepartmentPayrollResponse> response
                = new ApiResponse<>(null,null,result);
        return ResponseEntity.ok().body(response);
    }
}
