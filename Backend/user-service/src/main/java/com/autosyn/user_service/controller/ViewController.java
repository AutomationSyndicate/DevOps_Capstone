package com.autosyn.user_service.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_USER = "ROLE_USER";


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

//    @GetMapping("/dashboard")
//    public String dashboardPage(Authentication auth) {
//
//        auth.getAuthorities().forEach(a -> System.out.println("User authority: " + a.getAuthority()));
//
////        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(ROLE_ADMIN))) {
////            System.out.println("Authorities-admin: " + auth.getAuthorities());
////
////            return "redirect:/admin/dashboard";
////        }
////        else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(ROLE_USER))) {
////            System.out.println("Authorities-user: " + auth.getAuthorities());
////
////            return "redirect:/user/dashboard";
////        }
////
////        return "error";
//        String role = auth.getAuthorities().iterator().next().getAuthority();
//        return switch (role) {
//            case ROLE_USER -> "user-dashboard";
//            case ROLE_ADMIN -> "redirect:/admin/dashboard";
//
//            default -> "dashboard";
//        };
//    }
//
//    @GetMapping("/admin/dashboard")
//    public String admindashboardPage() {
//        return "admin-dashboard";
//    }
//
//    @GetMapping("/user/dashboard")
//    public String userdashboardPage() {
//        return "user-dashboard";
//    }

@GetMapping("/dashboard")
public String dashboardPage(Authentication auth) {
    for (GrantedAuthority authority : auth.getAuthorities()) {
        String role = authority.getAuthority();

        if (role.startsWith("ROLE_")) {

            String path = role.substring(5).toLowerCase();
            return path + "-dashboard";
        }
    }

    return "error"; // No matching role found
}

}
