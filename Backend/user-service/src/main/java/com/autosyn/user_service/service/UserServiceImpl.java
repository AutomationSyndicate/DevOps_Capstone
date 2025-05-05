package com.autosyn.user_service.service;

import com.autosyn.user_service.model.User;
import com.autosyn.user_service.service.UserService;
import com.autosyn.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateUser(User user) {
        Optional<User> existingUserOpt = userRepository.findById(user.getId());
        if ((existingUserOpt).isPresent()) {
            User existingUser = existingUserOpt.get();

            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());

            existingUser.setRole(user.getRole());
            existingUser.setPassword(existingUser.getPassword());

            userRepository.save(existingUser);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
