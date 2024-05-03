	package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entities.Course;
import com.luv2code.cruddemo.entities.Instructor;
import com.luv2code.cruddemo.entities.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// executed after the Spring Bean have loaded
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		//Java lampda expression
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// removeInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// removeInstructorDetail(appDAO);
			// createInstructorWithCourses(appDAO);
			findInstructorWithCourses(appDAO);
		};
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 7;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor.toString());
		System.out.println("Courses: " + instructor.getCourses());

		System.out.println("Done!!");
	}

	public void createInstructorWithCourses(AppDAO appDAO) {
		// create instance of instructor
		Instructor instructor = new Instructor("Mint", "Rosetta", "mint.rosetta2001@gmail.com");

		// create instance of instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com/youtube", "Mint Rosetta");
	
		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Course 1");
		Course course2 = new Course("Course 2");
		Course course3 = new Course("Course 3");

		instructor.add(course1);
		instructor.add(course2);
		instructor.add(course3);

		appDAO.save(instructor);

		System.out.println("Saving instructor: " + instructor.toString());
		System.out.println("Done!!");
	}

	public void removeInstructorDetail(AppDAO appDAO) {
		int id = 5;
		System.out.println("Deleting instructor detail id: " + id);

		appDAO.removeInstructorDetailById(id);

		System.out.println("Done!!");
	}

	public void findInstructorDetail(AppDAO appDAO) {
		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Detail: " + instructorDetail.toString());
		System.out.println("Instructor: " + instructorDetail.getInstructor().toString());
	}

	public void removeInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Deleting instructor id: " + id);
		appDAO.removeInstructorById(id);
		System.out.println("Done!");
	}

	public void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor.toString());
		System.out.println("Has details: " + instructor.getInstructorDetail().toString());
	}

	public void createInstructor(AppDAO appDAO) {

		/* 
		// create instance of instructor
		Instructor instructor = new Instructor("Chad", "Dady", "test@gmail.com");

		// create instance of instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com/youtube", "Luv 2 code!!!");
		*/

		// create instance of instructor
		Instructor instructor = new Instructor("Mint", "Rosetta", "mint.rosetta2001@gmail.com");

		// create instance of instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com/youtube", "Mint Rosetta");

		// add detail instance to instructor
		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor.toString());

		// save the instructor
		// this process will save detail because of CascadeType.ALL
		appDAO.save(instructor);

		System.out.println("Done");
	}

}
