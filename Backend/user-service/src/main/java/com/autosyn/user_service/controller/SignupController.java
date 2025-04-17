//package com.autosyn.user_service.controller;
//
//import com.autosyn.user_service.model.User;
//import com.autosyn.user_service.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.view.RedirectView;
//
//@Controller
//@RequestMapping("/req")
//public class SignupController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/signup")
//    public RedirectView registerUser(@ModelAttribute User user) {
//        if (userRepository.existsByEmail(user.getEmail())) {
//            return new RedirectView("/signup?error=email");
//        }
//        user.setEmail(user.getEmail());
//        user.setUsername(user.getUsername());
//        user.setPassword(user.getPassword());
//        user.setRole("ROLE_USER");
//
//        userRepository.save(user);
//        return new RedirectView("/login");
//    }
//}
