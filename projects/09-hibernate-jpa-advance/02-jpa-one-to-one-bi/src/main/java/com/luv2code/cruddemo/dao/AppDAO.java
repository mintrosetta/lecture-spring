package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entities.Instructor;
import com.luv2code.cruddemo.entities.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void removeInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
}
