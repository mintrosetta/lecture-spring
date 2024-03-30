package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.cruddemo.entities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// define ield for entity manager
	private EntityManager entityManager;
	
	// inject entity manager using ctor
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	// implement save method
	@Override
	@Transactional
	public void save(Student student) {
		this.entityManager.persist(student); // save student to database
	}

	@Override
	public Student findById(int id) {
		return this.entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// create query
		TypedQuery<Student> query = this.entityManager.createQuery("FROM Student", Student.class);
		
		// return query result
		return query.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		// create query
		TypedQuery<Student> query = this.entityManager.createQuery("FROM Student WHERE lastName = :lastName", Student.class);
		
		// set query parameters
		query.setParameter("lastName", lastName);
		
		// return query result
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		this.entityManager.merge(student); // update data
	}

	@Override
	@Transactional
	public void remove(int id) {
		// retrieve the student
		Student student = this.entityManager.find(Student.class, id);
		
		// delete the student
		this.entityManager.remove(student);
	}
}
