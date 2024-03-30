package com.luv2code.cruddemo;

import java.util.List;

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
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			removeStudent(studentDAO);
		};
	}

	public void removeStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.remove(studentId);
	}

	public void updateStudent(StudentDAO studentDAO) {
		// retriev student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDAO.findById(studentId);
		
		// change first name to "Scooby"
		System.out.println("Updating student");
		student.setFirstName("Scooby");
		
		// update the student
		studentDAO.update(student);
		
		// display the update student
		System.out.println(student.toString());
	}

	public void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findByLastName("Duck");
		
		// display list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void queryForStudents(StudentDAO studentDAO) {
		// get list of student
		List<Student> students = studentDAO.findAll();
		
		// display list of students
		for (Student student : students) {
			System.out.println(student.toString());
		}
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
