package com.lec.payroll.domain.payroll.service;

import com.lec.payroll.domain.employee.dto.response.EmployeeResponse;
import com.lec.payroll.domain.employee.model.Employee;
import com.lec.payroll.domain.employee.repository.EmployeeRepository;
import com.lec.payroll.domain.global.exception.CommonErrorCode;
import com.lec.payroll.domain.global.exception.GlobalException;
import com.lec.payroll.domain.payroll.dto.request.PayrollCreateRequest;
import com.lec.payroll.domain.payroll.dto.response.PayrollResponse;
import com.lec.payroll.domain.payroll.model.Payroll;
import com.lec.payroll.domain.payroll.repository.PayrollRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PayrollService {
    private final PayrollRepository payrollRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public void addPayroll(PayrollCreateRequest request) {
        verifyEmployeeExistence(request.employeeId());
        Payroll payroll = modelMapper.map(request, Payroll.class);
        payrollRepository.save(payroll);;
    }

    public PayrollResponse getPayroll(Long payrollId) {
        Payroll payroll = findPayrollById(payrollId);
        Employee employee = payroll.getEmployee();
        EmployeeResponse employeeResponse = convertEmployeeToResponse(employee);
        PayrollResponse response = new PayrollResponse(payroll.getId(),payroll.getPaycheck(),employeeResponse);
        return response;
    }

    private EmployeeResponse convertEmployeeToResponse(Employee employee) {
        EmployeeResponse employeeResponse = EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .salary(employee.getSalary())
                .department(employee.getDepartment())
                .position(employee.getPosition())
                .build();
        return employeeResponse;
    }

    private void verifyEmployeeExistence(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new GlobalException(CommonErrorCode.NOT_FOUND));
    }

    private Payroll findPayrollById(Long payrollId){
        Payroll payroll = payrollRepository.findById(payrollId)
                .orElseThrow(()-> new GlobalException(CommonErrorCode.NOT_FOUND));
        return payroll;
    }
}
