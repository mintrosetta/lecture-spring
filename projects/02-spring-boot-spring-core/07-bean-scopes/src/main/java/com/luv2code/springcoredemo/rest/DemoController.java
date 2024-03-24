package com.luv2code.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springcoredemo.common.ICoach;

@RestController
public class DemoController {
	// define a private field for the dependency
	private ICoach coach;

	private ICoach coach2;

	@Autowired
	public void setCoach(@Qualifier("cricketCoach") ICoach coach, @Qualifier("cricketCoach") ICoach coach2) {
		System.out.println("In constructor: " + getClass().getSimpleName());
		this.coach = coach;
		this.coach2 = coach2;
		System.out.println(this.coach == this.coach2);
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return this.coach.getDailyWorkout();
	}
}
