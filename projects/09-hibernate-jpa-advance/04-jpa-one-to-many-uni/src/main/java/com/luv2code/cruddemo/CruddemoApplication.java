package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entities.Course;
import com.luv2code.cruddemo.entities.Review;

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
			createCourseWithReview(appDAO);
		};
	}

	public void createCourseWithReview(AppDAO appDAO) {
		Course course = new Course("Java for beginners");
		course.addReview(new Review("Great course <3"));
		course.addReview(new Review("Great <3"));
		course.addReview(new Review("Thank you <3"));

		appDAO.save(course);
		System.out.println("Done!");
	}

}
