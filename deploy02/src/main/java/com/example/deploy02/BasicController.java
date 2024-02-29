package com.example.deploy02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    BasicService serviceBase;

    @GetMapping("/hi")
    public String hi() {
        return "Hello World";
    }

    @GetMapping("/")
    public String sumConv() {
        return serviceBase.sumTwoNumbers();
    }

    @GetMapping("/nomore")
    public String notTheSameThing(){
        return serviceBase.returnSomething();
    }
}
