//package com.autosyn.user_service.controller;
//
//import com.autosyn.user_service.model.User;
//import com.autosyn.user_service.repository.UserRepository;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.view.RedirectView;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.nio.charset.StandardCharsets;
//import java.util.Optional;
//
//@Controller
//public class LoginController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/login")
//    public RedirectView login(HttpServletRequest request) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String hashedPassword = hashPassword(password);
//
//        Optional<User> userOpt = userRepository.findByEmailAndPassword(username, hashedPassword);
//
//        if (userOpt.isPresent()) {
//            // Store user in session
//            HttpSession session = request.getSession();
//            session.setAttribute("user", userOpt.get());
//
//            return new RedirectView("/dashboard"); // or wherever you want to land
//        } else {
//            return new RedirectView("/login.html?error=true");
//        }
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
