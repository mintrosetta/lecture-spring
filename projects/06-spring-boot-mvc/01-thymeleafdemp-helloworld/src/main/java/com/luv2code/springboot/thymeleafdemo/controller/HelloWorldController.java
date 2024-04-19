package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {
    
    // need a controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // need a controller method to read form data and add data to the model
    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // read the request parameter from HTML form
        String name = request.getParameter("studentName");

        // convert the data to all caps
        name = name.toUpperCase();

        // create the message
        String result = "Yo! " + name;
        
        // add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String name, Model model) {
        name = name.toUpperCase();
        String result = "Hey my friend from V3 " + name;

        model.addAttribute("message", result);

        return "helloworld";
    }
}
