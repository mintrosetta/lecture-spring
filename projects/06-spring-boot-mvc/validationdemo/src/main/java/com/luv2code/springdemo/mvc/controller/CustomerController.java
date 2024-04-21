package com.luv2code.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.mvc.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        
        return "/customers/create";
    }

}
