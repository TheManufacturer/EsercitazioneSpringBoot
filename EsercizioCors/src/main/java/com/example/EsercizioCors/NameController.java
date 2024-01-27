package com.example.EsercizioCors;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/v1")
public class NameController {

    @Operation(

            summary = "Retrieve the name by Request parameter",
            description = "Get a name object by specifying its parameter. The response is a String with the name itself.",
            tags = { "nameController", "get" })

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returns the name in the parameter",content = {
                    @Content(schema = @Schema(implementation = NameController.class), mediaType = "application/json") }),

            @ApiResponse(responseCode = "400", description = "Malformed name parameter", content = {
                    @Content(schema = @Schema()) }),

            @ApiResponse(responseCode = "404", description = "Name not found or wrong mapping", content = {
                    @Content(schema = @Schema()) }) })


    @GetMapping(path = "/name")
    public String getNome(@RequestParam String nome){
        return nome;
    }

    @Operation(

            summary = "Retrieve the name by Request parameter",
            description = "Post a name object by specifying its parameter. The response is a String with the name reverse.",
            tags = { "nameController", "Post" })

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returns the name in the parameter",content = {
                    @Content(schema = @Schema(implementation = NameController.class), mediaType = "application/json") }),

            @ApiResponse(responseCode = "400", description = "Malformed name parameter", content = {
                    @Content(schema = @Schema()) }),

            @ApiResponse(responseCode = "404", description = "Name not found or wrong mapping", content = {
                    @Content(schema = @Schema()) }) })

    @PostMapping(path = "/name")
    public StringBuilder getNomeInvertito(@RequestParam String nome){
        StringBuilder invertito = new StringBuilder(nome);
        return invertito.reverse();
    }
}

/*
scrivi una applicazione web Spring Boot con:
    NameController dove si mappa il parametro name per:

    restituire il nome alla chiamata GET

    restuiture il nome al contrario (es. da John a nhoJ, usando StringBuilder) alla chiamata POST

    aggungi tutto il necessario per avere una documentazione completa delle endpoint create sopra (nome della chiamata, parametri ecc)

    testare le chiamate del API endpoint usando Postman
*/