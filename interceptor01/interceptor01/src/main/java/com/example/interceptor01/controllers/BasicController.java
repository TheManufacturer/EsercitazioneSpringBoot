package com.example.interceptor01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping(path = "")
public class BasicController {
    @GetMapping("/time")
    public OffsetDateTime getCurrentDateTime(){
        return OffsetDateTime.now();
    }
}

