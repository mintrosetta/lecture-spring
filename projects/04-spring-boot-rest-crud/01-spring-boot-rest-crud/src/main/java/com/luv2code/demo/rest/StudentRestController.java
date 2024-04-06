package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entities.Student;
import com.luv2code.demo.entities.StudentErrorResponse;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	// define @PostConstruct to load students data
	@PostConstruct
	public void loadData() {
		this.students = new ArrayList<Student>();

		this.students.add(new Student("Bike", "Chanokchon"));
		this.students.add(new Student("Mint", "Colorfuls"));
		this.students.add(new Student("Mint", "Rosetta"));
	}

	// defint endpoint for '/students' - return list of student
	@GetMapping("/students")
	public List<Student> getStudents() {
		return this.students;
	}

	// define endpoint for 'students/{studentId}' - return single student
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// check the studentId again list size
		if ((studentId >= this.students.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		return this.students.get(studentId); // use for get data from index
	}

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handlerException(StudentNotFoundException exc) {
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity, Response Entity with create response with specific
		// status code
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add anotheer exception handler to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleExpception(Exception exc) {
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
