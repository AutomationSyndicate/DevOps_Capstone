package com.autosyn.user_service.controller;

import com.autosyn.user_service.model.User;
import com.autosyn.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password
    ) {
        if (userRepository.existsByUsername(username) || userRepository.existsByEmail(email)) {
            return "redirect:/signup?error=exists";
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("ROLE_USER");
        userRepository.save(user);

        return "redirect:/login?signup=success";
    }

    @PostMapping("/req/signup")
    public String registerAdmin(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password
    ) {
        if (userRepository.existsByUsername(username) || userRepository.existsByEmail(email)) {
            return "redirect:/signup?error=exists";
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("ROLE_ADMIN");
        userRepository.save(user);

        return "redirect:/login?signup=success";
    }

}
