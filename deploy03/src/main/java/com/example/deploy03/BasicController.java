package com.example.deploy03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @Autowired
    BasicService serviceBase;

    @GetMapping("/")
    public String getAllSituationInProfile(){
        return serviceBase.getProperty();
    }
}
