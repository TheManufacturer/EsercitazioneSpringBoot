package com.example.Unittest.Controllers;

import com.example.Unittest.Entities.UserS;
import com.example.Unittest.Repository.UserSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UserS")
public class UserSController {

    @Autowired
    private UserSRepository userSRepository;

    @PostMapping("/create")
    public UserS createUserS(@RequestBody UserS UserS) {
        return userSRepository.save(UserS);
    }

    @GetMapping("/getList")
    public List<UserS> getAllUserSs() {
        return userSRepository.findAll();
    }

    @GetMapping("/getUserS/{id}")
    public UserS getUserSById(@PathVariable Long id) {
        Optional<UserS> optionalUserS = userSRepository.findById(id);
        if (optionalUserS.isPresent()) {
            return optionalUserS.get();
        } else {
            return null;
        }
    }

    @PutMapping("/updateUserS/{id}")
    public UserS updateUserS(@PathVariable Long id, @RequestBody UserS UserS) {
        UserS.setId(id);
        return userSRepository.save(UserS);
    }

    @DeleteMapping("/deleteUserS/{id}")
    public void deleteUserS(@PathVariable Long id) {
        userSRepository.deleteById(id);
    }
}

