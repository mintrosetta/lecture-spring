package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Value("${countries}") // get data from application.properties by key
    private List<String> countries;

    @Value("${favoriteLanguage}")
    private List<String> favoriteLanguages;

    @Value("${systems}")
    private List<String> systems;
    
    @GetMapping("/create")
    public String showForm(Model model) {
        // create a student object
        Student student = new Student();

        // add student object to attribute
        model.addAttribute("student", student);

        // add list of countries to the model
        model.addAttribute("countries", this.countries);

        // add list of favorite language to the model
        model.addAttribute("favoriteLanguages", this.favoriteLanguages);

        // add list of favorite systems to the model
        model.addAttribute("systems", this.systems);

        return "student-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("student") Student student) {
        // log the input data
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return "student-confirmation";
    }

}
