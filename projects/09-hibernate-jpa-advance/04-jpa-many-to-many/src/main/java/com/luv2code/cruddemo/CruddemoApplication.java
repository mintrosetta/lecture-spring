package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entities.Course;
import com.luv2code.cruddemo.entities.Student;

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
			// createCourseAndStudent(appDAO);
			getCourseWithStudents(appDAO);
		};
	}

	public void getCourseWithStudents(AppDAO appDAO) {
		int courseId = 10;
		
		Course course = appDAO.findCourseWithStudentByCourseId(courseId);

		System.out.println(course.toString());
		System.out.println(course.getStudents().toString());
	}

	public void createCourseAndStudent(AppDAO appDAO) {
		Course course = new Course();
		course.addStudent(new Student("Chanokchon", "Wongjampa", "a@gmail.com"));
		course.addStudent(new Student("Bike", "Colorfuls", "b@gmail.com"));
		
		appDAO.save(course);

		System.out.println("Done");
	}

}
