package com.example.interceptor02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class BasicController {
    @GetMapping
    public String helloUser(){
        return "Hello User, welcome !";
    }
}
