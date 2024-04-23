package com.luv2code.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/lists"
    @GetMapping("")
    public String listEmployee(Model model) {
        // get the employees from db
        List<Employee> employees = this.employeeService.findAll();

        // add to spring model
        model.addAttribute("employees", employees);
        
        return "list-employees";
    }
}
