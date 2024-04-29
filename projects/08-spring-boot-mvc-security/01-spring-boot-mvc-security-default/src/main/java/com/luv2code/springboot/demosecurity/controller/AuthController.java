package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "auth/login";
    }

    // add request mapping for access-denied
    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {
        return "auth/access-denied";
    }
}
