package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.IEmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	private IEmployeeDAO employeeDAO;
	
	@Autowired 
	public EmployeeRestController(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@GetMapping("")
	public List<Employee> getEmployees() {
		return this.employeeDAO.findAll();
	}
}
