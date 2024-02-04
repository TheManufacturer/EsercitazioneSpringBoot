package com.example.FirstCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstCrudApplication.class, args);
	}

}
/*
scrivi una applicazione web Spring Boot con le dipendenze neccessarie che:
ha una entità chiamata Car con le seguenti colonne:
id
modelName
type
ha un repository dedicato per Car
ha un controller dedicato per Car che:
è mapped su cars
esegue le operazioni CRUD:
crea nuova Car
restituisce la lista di tutte le Car
restituisce una singola Car - se id non è presente in db (usa existsById()), restituisce Car vuota
aggiorna type della Car specifica, identificata da id e passando query param - se id non è presente in db (usa existsById()), restituisce Car vuota
cancella la Car specifica - se non presente, la risposta deve avere Conflict HTTP status
cancella tutte le Cars in db
fai test delle endpoints usando Postman:
crea 2 macchine diverse
prendi tutte le macchine
prendi una macchina usando id
prendi una macchina non esistente
aggiorna type di una macchina esistente
aggiorna una macchina non esistente
cancella una macchina esistente
cancella una macchina non esistente
cancella tutta la base dati
 */