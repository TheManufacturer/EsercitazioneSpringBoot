package com.example.demo.PrimoEsercizio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/v1")
public class  ControllerEsercizioDevelopePrimo {
    @RequestMapping(method = GET, path = "/helloWorld")
    public String helloWorld(){
        return "Hello World BD !";
    }

    @GetMapping(path = "/salutoNomeLuogo")
    public String salutoNomeLuogo(@RequestParam String nome, @RequestParam String luogo){
        return "Ciao " + nome + " com'è il tempo in " + luogo;
    }

}
/*
 Scrivi una applicazione web Spring Boot che alla endpoint GET
 v1/ciao?nome=Giuseppe&provincia=Lombardia risponde con "Ciao Giuseppe,
 com'è il tempo in Lombardia?"

*/