package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

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
        
        return "employees/index";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("employee") Employee employee) {
        // save the employee
        this.employeeService.save(employee);

        // use a redirect to prevent dpulicate submission
        return "redirect:/employees";
    }

    @GetMapping("/update")
    public String getUpdatePage(Model model, @RequestParam("employeeId") int id) {
        // get employee from the service
        Employee employee = this.employeeService.findById(id);

        // set employee in the model prepopulate the form
        model.addAttribute("employee", employee);

        // send over to our form
        return "employees/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("employee") Employee employee) {
        this.employeeService.save(employee);

        return "redirect:/employees";
    }
}
