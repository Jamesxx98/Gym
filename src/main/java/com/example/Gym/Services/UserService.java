package com.example.Gym.Services;

import com.example.Gym.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findUserById(int id);
    List<User> getAllUsers();
    Optional<User> authenticateUser(String email, String password);
}
