package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.IEmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.services.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	private IEmployeeService employeeService;
	
	@Autowired 
	public EmployeeRestController(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("")
	public List<Employee> getEmployees() {
		return this.employeeService.finds();
	}
}
