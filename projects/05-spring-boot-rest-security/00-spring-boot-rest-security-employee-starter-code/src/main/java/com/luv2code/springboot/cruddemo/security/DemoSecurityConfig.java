package com.luv2code.springboot.cruddemo.security;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	@Bean
	public InMemoryUserDetailsManager userDetailManager() {
		UserDetails jhon = User.builder().username("jhon").password("{noop}test123").roles("EMPLOYEE").build();

		UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails susan = User.builder().username("susan").password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();

		List<UserDetails> users = new ArrayList<UserDetails>();
		users.add(jhon);
		users.add(mary);
		users.add(susan);

		return new InMemoryUserDetailsManager(users);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		String baseEmployeeAPI = "/api/employees";

		http.authorizeHttpRequests(config -> 
			config.requestMatchers(HttpMethod.GET, baseEmployeeAPI).hasRole("EMPLOYEE")
			.requestMatchers(HttpMethod.GET, baseEmployeeAPI + "/**").hasRole("EMPLOYEE")
			.requestMatchers(HttpMethod.POST, baseEmployeeAPI).hasRole("MANAGER")
			.requestMatchers(HttpMethod.PUT, baseEmployeeAPI).hasRole("MANAGER")
			.requestMatchers(HttpMethod.PUT, baseEmployeeAPI + "/**").hasRole("MANAGER")
			.requestMatchers(HttpMethod.DELETE, baseEmployeeAPI + "/**").hasRole("ADMIN")
		);

		// tell spring, use basic authentication
		http.httpBasic(Customizer.withDefaults());

		// disable csrf
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}
}
