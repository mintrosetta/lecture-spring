package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	private IEmployeeService employeeService;
	
	public EmployeeRestController(IEmployeeService employeeRepository) {
		this.employeeService = employeeRepository;
	}
	
	@GetMapping("")
	public List<Employee> findAll() {
		return this.employeeService.findAll();
	}
	
	@GetMapping("/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee employee = this.employeeService.findById(employeeId);
		
		if (employee == null) throw new RuntimeException("Employee id not found - " + employeeId);
		
		return employee;
	}
	
	@PostMapping("")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		Employee savedEmployee = this.employeeService.save(employee);
		
		return savedEmployee;
	}
	
	@PutMapping("")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = this.employeeService.save(employee);
		
		return updatedEmployee;
	}
	
	@DeleteMapping("/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = this.findById(employeeId);
		
		if (employee == null) throw new RuntimeException("Employee id not found - " + employeeId);
		
		this.employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
}
