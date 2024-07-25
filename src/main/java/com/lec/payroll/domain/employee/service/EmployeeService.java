package com.lec.payroll.domain.employee.service;

import com.lec.payroll.domain.employee.dto.request.EmployeeCreateRequest;
import com.lec.payroll.domain.employee.model.Employee;
import com.lec.payroll.domain.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public void addEmployee(EmployeeCreateRequest request) {
        Employee employee = modelMapper.map(request, Employee.class);
        employeeRepository.save(employee);
    }
}
