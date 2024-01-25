package com.example.esercizioGetPost;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class NameController {
    @GetMapping(path = "/name")
    public String getNome(@RequestParam String nome){
        return nome;
    }
    @PostMapping(path = "/name")
    public StringBuilder getNomeInvertito(@RequestParam String nome){
        StringBuilder invertito = new StringBuilder(nome);
        return invertito.reverse();
    }
}

/*
scrivi una applicazione web Spring Boot con:
NameController dove si mappa il parametro name per:
    -restituire il nome alla chiamata GET
    -restuiture il nome al contrario (es. da John a nhoJ, usando StringBuilder) alla chiamata POST
testare le chiamate del API endpoint usando Postman
*/