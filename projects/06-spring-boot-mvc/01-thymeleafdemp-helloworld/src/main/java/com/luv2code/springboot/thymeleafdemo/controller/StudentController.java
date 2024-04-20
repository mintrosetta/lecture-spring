package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
    
    @GetMapping("/create")
    public String showForm(Model model) {
        // create a student object
        Student student = new Student();

        // add student object to attribute
        model.addAttribute("student", student);

        return "student-create";
    }

}
