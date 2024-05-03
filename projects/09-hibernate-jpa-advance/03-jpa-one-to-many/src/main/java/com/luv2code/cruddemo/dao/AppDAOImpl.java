package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entities.Course;
import com.luv2code.cruddemo.entities.Instructor;
import com.luv2code.cruddemo.entities.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

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

    @Override
    @Transactional
    public void removeInstructorById(int id) {
       // retrieve the instructor
        Instructor instructor = this.entityManager.find(Instructor.class, id);

       // delete instructor
       this.entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return this.entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void removeInstructorDetailById(int id) {
        InstructorDetail instructorDetail = this.entityManager.find(InstructorDetail.class, id);
        
        // break bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);

        this.entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = this.entityManager.createQuery("FROM Course WHERE instructor.id = :data", Course.class);
        query.setParameter("data", id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        // create query
        String queryString = "SELECT i FROM Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail WHERE i.id = :data";
        
        TypedQuery<Instructor> query = this.entityManager.createQuery(queryString, Instructor.class);
        query.setParameter("data", id);

        return query.getSingleResult();
    }
    
}
 