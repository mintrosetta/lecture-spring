package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.AppDAO;
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
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {

		// create instance of instructor
		Instructor instructor = new Instructor("Chad", "Dady", "test@gmail.com");

		// create instance of instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com/youtube", "Luv 2 code!!!");

		// add detail instance to instructor
		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor.toString());

		// save the instructor
		// this process will save detail because of CascadeType.ALL
		appDAO.save(instructor);

		System.out.println("Done");
	}

}
