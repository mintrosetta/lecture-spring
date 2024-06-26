package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.entities.Course;
import com.luv2code.cruddemo.entities.Instructor;
import com.luv2code.cruddemo.entities.InstructorDetail;
import com.luv2code.cruddemo.entities.Student;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void removeInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void removeInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void updateInstructor(Instructor instructor);
    void updateCourse(Course course);
    Course findCourseById(int id);
    void removeCourseById(int id);
    void save(Course course);
    Course findCourseWithReviewByCourseId(int id);
    Course findCourseWithStudentByCourseId(int id);
    Student findStudentWithCourseByStudentId(int id);
    void update(Student student);
    Student findStudent(int id);
    void removeStudentById(int id);
}
