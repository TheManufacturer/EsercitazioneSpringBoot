package com.example.customQuery1.controllers;

import com.example.customQuery1.entities.Flight;
import com.example.customQuery1.entities.FlightStatus;
import com.example.customQuery1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    //Creazione End-Point Creazione "Voli" Random
    @PostMapping("/provisioning")
    public List<Flight> fillListOfFlight() {
        for (int i = 0; i <= 50; i++) {
            Random randomNumber = new Random();

            Integer int_description = randomNumber.nextInt(999999);
            Integer int_fromAirport = randomNumber.nextInt(999999);
            Integer int_toAirport = randomNumber.nextInt(999999);

            String descriptionString = int_description.toString();
            String fromAirportString = int_fromAirport.toString();
            String toAirportString = int_toAirport.toString();

            Flight flight = new Flight(i,descriptionString,fromAirportString,toAirportString,FlightStatus.ONTIME);
        /*
            //Usiamo builder con tutto il neccessario **check in Entity Flight**

            Flight flight = Flight.builder()
                    .description(descriptionString)
                    .fromAirport(fromAirportString)
                    .toAirport(toAirportString)
                    .flightStatus(FlightStatus.ONTIME)
                    .build();
        */
            flightRepository.saveAndFlush(flight);
        }
        return flightRepository.findAll();
    }

    //Creazione End-Point GET tutti i voli
    @GetMapping("/retrivieng")
    public List<Flight> getListOfFlight() {
        return flightRepository.findAll();
    }

    //Creazione End-Point Voli ONTIME
    @GetMapping("/retrivieng/ontime")
    public List<Flight> flightStatusOnTime() {
        return flightRepository.searchFlights(FlightStatus.ONTIME.name());
        //.name --> prende il valore dall'enum (tipo toString)
    }

    //End-Point Eliminazione da salvare
    @DeleteMapping("/deleteAllFlights")
    public boolean deleteAllData() {
        try {
            flightRepository.deleteAll();
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @GetMapping("/searchbydeparture")
    public List<Flight> searchByAirport(@RequestParam String airport){
        return flightRepository.searchByDeparture(airport);
    }
}


//Commentate tutte le parti con il Builder