package com.lec.payroll.backend.payroll.service;

import com.lec.payroll.backend.employee.dto.response.EmployeeResponse;
import com.lec.payroll.backend.employee.model.Department;
import com.lec.payroll.backend.employee.model.Employee;
import com.lec.payroll.backend.employee.repository.EmployeeRepository;
import com.lec.payroll.backend.global.exception.CommonErrorCode;
import com.lec.payroll.backend.global.exception.GlobalException;
import com.lec.payroll.backend.payroll.dto.request.PayrollCreateRequest;
import com.lec.payroll.backend.payroll.dto.response.DepartmentPayrollResponse;
import com.lec.payroll.backend.payroll.dto.response.PayrollResponse;
import com.lec.payroll.backend.payroll.model.Payroll;
import com.lec.payroll.backend.payroll.repository.PayrollDslRepository;
import com.lec.payroll.backend.payroll.repository.PayrollRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PayrollService {
    private final PayrollRepository payrollRepository;
    private final EmployeeRepository employeeRepository;
    private final PayrollDslRepository payrollDslRepository;
    private final ModelMapper modelMapper;

    public void addPayroll(PayrollCreateRequest request) {
        verifyEmployeeExistence(request.employeeId());
        Payroll payroll = modelMapper.map(request, Payroll.class);
        payrollRepository.save(payroll);
    }

    public PayrollResponse getPayroll(Long payrollId) {
        Payroll payroll = findPayrollById(payrollId);
        return convertPayrollToResponse(payroll);
    }

    public List<PayrollResponse> getPayrolls(int page, int size) {
        List<Payroll> payrolls = payrollDslRepository.getAllPayrolls(page, size);
        List<PayrollResponse> responses = payrolls
                .stream()
                .map(payroll -> convertPayrollToResponse(payroll))
                .toList();
        return responses;
    }

    public DepartmentPayrollResponse getTotalPayrollByDepartment(Department department) {
        Integer sum = payrollDslRepository.getTotalPayrollsByDepartment(department);
        return DepartmentPayrollResponse
                .builder()
                .departmentName(department.toString())
                .totalPaycheck(sum)
                .build();
    }

    private PayrollResponse convertPayrollToResponse(Payroll payroll) {
        Employee employee = payroll.getEmployee();
        EmployeeResponse employeeResponse = convertEmployeeToResponse(employee);
        return new PayrollResponse(payroll.getId(),payroll.getPaycheck(),employeeResponse);
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
