package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class DemoController {

	@GetMapping("")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/leaders")
	public String showLeadersPage() {
		return "leaders";
	}

	@GetMapping("/systems")
	public String showSystemsPage() {
		return "systems";
	}
	
}
