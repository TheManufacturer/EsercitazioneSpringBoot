package com.example.customQuery2.controllers;

import com.example.customQuery2.entities.Flight;
import com.example.customQuery2.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;

    //End-Point visualizzazione totale
    @GetMapping("/retrieving")
    public List<Flight> allFlight() {
        return flightService.findAllFlight();
    }

    //End-Point lista voli ordinati in base a fromAirport
    @GetMapping("/retrievieng/orderfromairport")
    public List<Flight> listOrderByFromAirport(){
        return flightService.listFlightFromAirport();
    }

    //End-Point Voli OnTime
    @GetMapping("/retrieving/ontime")
    public List<Flight> findFlightOnTime() {
        return flightService.searchOnTime();
    }

    //End-Point Voli con status
    @GetMapping("/single/{findStatus}")
    public List<Flight> findByStatus(@PathVariable String findStatus) {
        String status = findStatus.toUpperCase();
        return flightService.searchByStatus(status);
    }

    //endpoint voli con 2 status
    @GetMapping("/double/{firstStatus},{secondStatus}")
    public List<Flight> findByDoubleStatus(@PathVariable String firstStatus, @PathVariable String secondStatus) {
        String status = firstStatus.toUpperCase();
        String status2 = secondStatus.toUpperCase();
        return flightService.searchByDoubleStatus(status, status2);
    }

    //End-Point Creazione Voli Standard -100
    @PostMapping("/provisioning")
    public List<Flight> fillListOffFlight(@RequestParam(required = false, defaultValue = "100") int n) {
        return flightService.populateListWithFlight(n);
    }

    //End-Point Eliminazione
    @DeleteMapping("/deleteAllFlights")
    public boolean deleteAll() {
        return flightService.deleteAllData();
    }
}
