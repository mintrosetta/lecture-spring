package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// executed after the Spring Bean have loaded
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		//Java lampda expression
		return runner -> {
			System.out.println("Hello World");
		};
	}

}
