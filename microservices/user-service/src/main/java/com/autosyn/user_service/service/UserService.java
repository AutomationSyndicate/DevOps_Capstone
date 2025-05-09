package com.autosyn.user_service.service;

import com.autosyn.user_service.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void updateUser(User user);
    void deleteUserById(Long id);
}
