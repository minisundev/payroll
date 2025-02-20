package com.lec.payroll.frontend.employee;

import com.lec.payroll.backend.employee.controller.EmployeeController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class EmployeeFrontController {

    private final EmployeeController employeeController;

    @GetMapping("/")
    public String home() {
        return "redirect:/employee";
    }

    @GetMapping("/employee")
    public String getEmployees(Model model) {
        model.addAttribute("response", employeeController.getEmployees());
        return "employees";
    }

    @GetMapping("/employee/create")
    public String createEmployee() {
        return "createEmployee";
    }
}
