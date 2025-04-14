package com.autosyn.user_service.controller;

import com.autosyn.user_service.dto.SignupRequest;
import com.autosyn.user_service.model.User;
import com.autosyn.user_service.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/req")
public class SignUpController {

    private final UserRepository userRepository;

    public SignUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        if (userRepository.existsById(request.getId())) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        User user = new User();
        user.setId(Math.toIntExact(request.getId()));
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());


        userRepository.save(user);
        return ResponseEntity.ok("User signed up successfully");
    }
}
