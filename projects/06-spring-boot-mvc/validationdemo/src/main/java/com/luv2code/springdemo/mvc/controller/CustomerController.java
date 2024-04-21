package com.luv2code.springdemo.mvc.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.mvc.model.Customer;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // add an initbinder ... to convert trim input string
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());

        return "/customers/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        System.out.println("Last name: " + customer.getLastName());
        if (bindingResult.hasErrors()) {
            return "/customers/create";
        }

        return "/customers/confirmation";
    }

}
