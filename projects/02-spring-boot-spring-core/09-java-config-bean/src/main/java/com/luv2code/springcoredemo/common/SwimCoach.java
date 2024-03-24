package com.luv2code.springcoredemo.common;

public class SwimCoach implements ICoach {

	public SwimCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as warm up";
	}

}
