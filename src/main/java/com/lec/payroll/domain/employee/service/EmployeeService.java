package com.lec.payroll.domain.employee.service;

import com.lec.payroll.domain.employee.dto.request.EmployeeCreateRequest;
import com.lec.payroll.domain.employee.dto.response.EmployeeResponse;
import com.lec.payroll.domain.employee.model.Employee;
import com.lec.payroll.domain.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public void addEmployee(EmployeeCreateRequest request) {
        Employee employee = modelMapper.map(request, Employee.class);
        employeeRepository.save(employee);
    }

    public List<EmployeeResponse> getEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> responses = employees
                .stream()
                .map(e -> convertEmployeeToResponse(e))
                .toList();
        return responses;
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
}
