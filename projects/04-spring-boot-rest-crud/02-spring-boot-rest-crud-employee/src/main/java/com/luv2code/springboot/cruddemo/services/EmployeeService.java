package com.luv2code.springboot.cruddemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.IEmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

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

}
