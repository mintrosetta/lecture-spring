package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAO implements IEmployeeDAO {
	// define field for entityManager
	private EntityManager entityManager;
	
	// setup constructor injection
	@Autowired
	public EmployeeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// create query
		TypedQuery<Employee> query = this.entityManager.createQuery("FROM Employee", Employee.class);
		
		// get result as list
		List<Employee> employees = query.getResultList();
		
		// return
		return employees;
	}

}
