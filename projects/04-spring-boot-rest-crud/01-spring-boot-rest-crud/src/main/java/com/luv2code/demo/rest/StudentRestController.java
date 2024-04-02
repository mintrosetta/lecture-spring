package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entities.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// defint endpoint for '/students' - return list of student
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Bike", "Chanokchon"));
		students.add(new Student("Mint", "Colorfuls"));
		students.add(new Student("Mint", "Rosetta"));
		
		return students;
	}
	
}
