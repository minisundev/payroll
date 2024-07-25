package com.lec.payroll.domain.payroll.controller;

import com.lec.payroll.domain.global.response.ApiResponse;
import com.lec.payroll.domain.payroll.dto.request.PayrollCreateRequest;
import com.lec.payroll.domain.payroll.dto.response.PayrollResponse;
import com.lec.payroll.domain.payroll.model.Payroll;
import com.lec.payroll.domain.payroll.service.PayrollService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/payroll")
public class PayRollController {
    private final PayrollService payrollService;

    @PostMapping("")
    public ResponseEntity<ApiResponse<Void>> addPayroll(
            @Valid @RequestBody PayrollCreateRequest request
    ) {
        payrollService.addPayroll(request);
        String msg = "Payroll added successfully";
        ApiResponse<Void> response = new ApiResponse<Void>(null, msg, null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}
