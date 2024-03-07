package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {
    @Autowired
    Environment environment;

    Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public Integer calculateExponent(){
        try{
            Integer num1 = Integer.valueOf(environment.getProperty("int1"));
            Integer num2 = Integer.valueOf(environment.getProperty("int2"));

            logger.info("This is the message before the calculation");

            Integer result = (int) Math.pow(num1, num2);

            logger.info("Logging the result. Result = "+ result);

            return result;
        }finally {
            logger.info("This is the message after the calculation is returned");
        }
    }

}
