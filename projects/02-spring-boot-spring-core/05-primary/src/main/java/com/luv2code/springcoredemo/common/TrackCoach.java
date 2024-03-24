package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoach implements ICoach {

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5K!";
	}

}
