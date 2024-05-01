package com.luv2code.cruddemo.dao;

import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entities.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl  implements AppDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        this.entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return this.entityManager.find(Instructor.class, id);
    }
    
}
