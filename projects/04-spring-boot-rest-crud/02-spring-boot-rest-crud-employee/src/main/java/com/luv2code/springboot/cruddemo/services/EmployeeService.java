package com.luv2code.springboot.cruddemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.IEmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService implements IEmployeeService {
	private IEmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeService(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	public List<Employee> finds() {
		return this.employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		return this.employeeDAO.findById(id);
	}

	@Transactional
	@Override
	public Employee save(Employee employee) {
		return this.employeeDAO.save(employee);
	}

	@Transactional
	@Override
	public void removeById(int id) {
		this.employeeDAO.removeById(id);
	}

}
