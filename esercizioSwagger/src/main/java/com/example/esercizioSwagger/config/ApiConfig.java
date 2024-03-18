package com.example.esercizioSwagger.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Antonio",
                        email = "prova@mail.com",
                        url = "http://prova.test.com"
                ),
                description = "prova di documentazione con swagger per esercizio",
                title = "Esercizio di Spring SWAGGER",
                version = "1.0",
                license = @License(
                        name = "freelicence",
                        url = "http://openlicence.prova.test"
                ),
                termsOfService = "terms of service"
        ),
        servers= {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }
)
public class ApiConfig {

}