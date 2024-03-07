package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController{
    @Autowired
    LoggingService loggingService;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/")
    public String getMessage(){
        logger.info("This is a message from the logger in LoggerController-getMessage");
        return "Hello! This is the message from the Basic Controller";
    }

    @GetMapping("/exp")
    public Integer getExponent(){
        return loggingService.calculateExponent();
    }

    @GetMapping("/get-errors")
    public void getError(){
        Error error = new Error("This is my new, extremely detailed and useful custom error :)");
        logger.error("Here an error message will be thrown and logged: ", error);
    }

}
