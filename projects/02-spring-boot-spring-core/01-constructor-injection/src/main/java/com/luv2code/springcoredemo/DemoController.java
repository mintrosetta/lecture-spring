package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	// define a private field for the dependency
	private ICoach coach;
	
	// define a constructor for dependency injection
	@Autowired // if only have one constructor, Autowired is optional
	public DemoController(ICoach coach) {
		this.coach = coach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return this.coach.getDailyWorkout();
	}
}
