package com.example.SpringEsercizio12.controller;

import com.example.SpringEsercizio12.entities.User;
import com.example.SpringEsercizio12.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public User createUser(@RequestBody User User) {
        return userRepository.save(User);
    }

    @GetMapping("/getList")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }

    @PutMapping("/updateUser/{id}")
    public User updateUserS(@PathVariable Long id, @RequestBody User User) {
        User.setId(id);
        return userRepository.save(User);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserS(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
