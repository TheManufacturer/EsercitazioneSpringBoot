package com.example.deploy02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BasicService {
    @Autowired
    Environment environment;

    public String sumTwoNumbers() {

        // Converte le stringhe in numeri interi
        Integer firstNumber = Integer.parseInt(Objects
                .requireNonNull(environment.getProperty("myCustomVar.customInt1")));

        Integer secondNumber = Integer.parseInt(Objects
                .requireNonNull(environment.getProperty("myCustomVar.customInt2")));

        int sum = firstNumber + secondNumber;

        return Integer.toString(sum);
    }

    public String returnSomething(){
        return environment.getProperty("myCustomVar.customVar");
    }

}
