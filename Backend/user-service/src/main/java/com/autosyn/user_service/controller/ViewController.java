package com.autosyn.user_service.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @GetMapping("/")
    public String home() {
        return "login"; // optional
    }

    @GetMapping("/dashboard")
    public String dashboardPage(Authentication auth) {

        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/dashboard/admin";
        }
        else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
            return "redirect:/dashboard/user";
        }


        return "error";
    }

    @GetMapping("/dashboard/admin")
    public String admindashboardPage() {
        return "admin-dashboard";
    }

    @GetMapping("/dashboard/user")
    public String userdashboardPage() {
        return "user-dashboard";
    }
}
