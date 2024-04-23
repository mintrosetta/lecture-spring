package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by lastName
    // Spring data jpa will auto create query by method name, find all, order by last name asc
    public List<Employee> findAllByOrderByLastNameAsc();

}
