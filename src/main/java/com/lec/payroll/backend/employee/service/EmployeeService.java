package com.lec.payroll.backend.employee.service;

import com.lec.payroll.backend.employee.dto.request.EmployeeCreateRequest;
import com.lec.payroll.backend.employee.dto.response.EmployeeResponse;
import com.lec.payroll.backend.employee.model.Department;
import com.lec.payroll.backend.employee.model.Employee;
import com.lec.payroll.backend.employee.model.Position;
import com.lec.payroll.backend.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public List<Position> getPositions(){
        return Arrays.asList(Position.values());
    }

    public List<Department> getDepartments(){
        return Arrays.asList(Department.values());
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
