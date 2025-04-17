package com.autosyn.user_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/req/signup")
    public String signupPage() {
        return "signup";
    }

    @GetMapping("/")
    public String home() {
        return "login"; // optional
    }
}
