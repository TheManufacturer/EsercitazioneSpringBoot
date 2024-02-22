package com.example.interceptor02.controllers;

import com.example.interceptor02.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping
    public Month getMonth(HttpServletRequest request){
        Month month = (Month) request.getAttribute("month");
        if (month == null) {
            return month;
        }else {
            return new Month(null, "nope","nope","nope");
        }
    }
}
