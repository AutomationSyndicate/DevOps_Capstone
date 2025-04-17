package com.autosyn.user_service.controller;

import com.autosyn.user_service.model.User;
import com.autosyn.user_service.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @PostMapping("/save")
    public String saveUser(User user){
        userRepository.save(user);
        return "User added";
    }

    @PutMapping("update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user){
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setUsername(user.getUsername());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        userRepository.save(updatedUser);
        return "User updated";
    }

//    @GetMapping("/req/signup")
//    public String signup() {
//        return "signup";
//    }
}


//@Controller
//@RequestMapping("/req")
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/signup")
//    public RedirectView registerUser(HttpServletRequest request) {
//        String username = request.getParameter("username");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String role = request.getParameter("role");
//
//        if (userRepository.existsByEmail(email)) {
//            return new RedirectView("/signup.html?error=email");
//        }
//
//        User user = new User();
//        user.setUsername(username);
//        user.setEmail(email);
//        user.setPassword(hashPassword(password)); // Use simple hashing or skip
//        user.setRole(role);
//        user.setCreatedAt(LocalDateTime.now());
//
//        userRepository.save(user);
//        return new RedirectView("/login.html");
//    }
//
//    private String hashPassword(String password) {
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] encoded = digest.digest(password.getBytes(StandardCharsets.UTF_8));
//            StringBuilder hex = new StringBuilder();
//            for (byte b : encoded) {
//                hex.append(String.format("%02x", b));
//            }
//            return hex.toString();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException("Error hashing password");
//        }
//    }
//}
