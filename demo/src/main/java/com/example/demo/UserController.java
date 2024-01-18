package com.example.demo;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("v2/")
public class UserController {
    @GetMapping("ciao/{localita}")
    public User printUser(@PathVariable String localita, @RequestParam String nome){
        String saluto = "Ciao "+ nome + " com'è il tempo in " + localita;
        User user1 = new User(nome, localita, saluto);
        return user1;
    }
}


/*
Scrivi una applicazione web Spring Boot che alla endpoint
        GET v2/ciao/Lombardia?nome=Giuseppe

risponde con un oggetto JSON formato cosi:

{
    "nome": "Giuseppe",
    "provincia": "Lombardia",
    "saluto": "Ciao Giuseppe, com'è il tempo in Lombardia?"
}
*/