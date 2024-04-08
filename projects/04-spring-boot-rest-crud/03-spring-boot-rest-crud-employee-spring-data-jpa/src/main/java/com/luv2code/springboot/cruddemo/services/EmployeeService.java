package com.luv2code.springboot.cruddemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService implements IEmployeeService {
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeDAO) {
		this.employeeRepository = employeeDAO;
	}
	
	@Override
	public List<Employee> finds() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = this.employeeRepository.findById(id);
		
		Employee employee = null;
		if (result.isPresent()) employee = result.get();
		
		return employee;
	}

	// @Transactional if use JpaRepository, no need them because JpaRepository control it
	@Override
	public Employee save(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	// @Transactional
	@Override
	public void removeById(int id) {
		this.employeeRepository.deleteById(id);
	}

}
