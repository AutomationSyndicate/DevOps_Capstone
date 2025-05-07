package com.autosyn.user_service.controller;

import com.autosyn.user_service.model.User;
import com.autosyn.user_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private UserService userService;

    @Operation(summary = "Login page")
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @Operation(summary = "User signup page")
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @Operation(summary = "Admin signup")
    @GetMapping("/req/signup")
    public String adminSignupPage() {
        return "admin-signup";
    }

    @Operation(summary = "User/Admin login is the default page")
    @GetMapping("/")
    public String home() {
        return "login"; // optional
    }

    @Operation(summary = "User/Admin Dashboard")
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

    @Operation(summary = "List all users")
    @GetMapping("/users")
    public String manageUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "manage-users";
    }

    @Operation(summary = "Edit a user by ID")
    @GetMapping("/user/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";
    }

    @Operation(summary = "Update a user")
    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @Operation(summary = "Delete a user by ID")
    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @Operation(
            summary = "Get current user",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }

}
