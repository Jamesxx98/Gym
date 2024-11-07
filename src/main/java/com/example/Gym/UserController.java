package com.example.Gym;

import com.example.Gym.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserRepo userRepo;
    @PostMapping("login")
    User login(@RequestBody User userLogin ){
        return userRepo.save(userLogin) ;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
