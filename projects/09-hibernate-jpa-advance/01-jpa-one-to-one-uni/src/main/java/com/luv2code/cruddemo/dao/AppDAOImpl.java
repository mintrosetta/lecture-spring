package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entities.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

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
    
}
