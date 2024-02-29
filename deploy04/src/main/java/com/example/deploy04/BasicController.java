package com.example.deploy04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @Autowired
    BasicService serviceBase;

    @GetMapping("/notforthisexercise")
    public String getAllSituationInProfile(){
        return serviceBase.getProperty();
    }

    @GetMapping("/")
    public String takeYourWelcome(){
        return serviceBase.getWelcome();
    }

}
