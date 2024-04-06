package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entities.Student;

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
		return this.students.get(studentId); // use for get data from index
	}
}
