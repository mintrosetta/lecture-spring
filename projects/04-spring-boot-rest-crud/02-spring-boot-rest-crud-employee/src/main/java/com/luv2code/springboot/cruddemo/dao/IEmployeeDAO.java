package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface IEmployeeDAO {
	List<Employee> findAll();
	Employee findById(int id);
	Employee save(Employee employee);
	void removeById(int id);
}
