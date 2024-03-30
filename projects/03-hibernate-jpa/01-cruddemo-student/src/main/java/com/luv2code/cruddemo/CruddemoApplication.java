package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entities.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudent(studentDAO);
			readStudent(studentDAO);
		};
	}

	public void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Createing new student object");
		Student student = new Student("Daffy", "Duck", "daffyD@gmail.com");
		
		// save the student
		System.out.println("Saving the student");
		studentDAO.save(student);
		
		// display id of the saved student
		int studentId = student.getId();
		System.out.println("Saved student with id : " + studentId);
		
		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + studentId);
		Student reStudent = studentDAO.findById(studentId);
		
		// display student
		System.out.println("Found the student: " + reStudent.toString());
	}

	public void createMultipleStudent(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating new student object");
		Student student1 = new Student("Mint", "Rosetta", "mint.rosetta2001@gmail.com");
		Student student2 = new Student("Mint", "Colorful", "mint.colorful2001@gmail.com");
		Student student3 = new Student("Mint", "Hiroshi", "mint.hiroshi2001@gmail.com");
		
		// save the student object
		System.out.println("Saving the students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	public void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student student = new Student("Mint", "Rosetta", "mint.rosetta2001@gmail.com");
		
		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(student);
		
		// display id of the saved object
		System.out.println("Saved student with id : " + student.getId());
	}
}
