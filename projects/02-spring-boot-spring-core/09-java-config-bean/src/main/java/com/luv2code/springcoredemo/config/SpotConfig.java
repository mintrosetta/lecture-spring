package com.luv2code.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.springcoredemo.common.ICoach;
import com.luv2code.springcoredemo.common.SwimCoach;

@Configuration
public class SpotConfig {
	@Bean("aquatic")
	public ICoach swimCoach() {
		return new SwimCoach();
	}
}
