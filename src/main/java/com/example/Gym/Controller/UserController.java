package com.example.Gym.Controller;

import com.example.Gym.Model.User;
import com.example.Gym.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User userLogin) {
        Optional<User> user = userService.authenticateUser(userLogin.getEmail(), userLogin.getPassword());
        return user.orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.findUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}