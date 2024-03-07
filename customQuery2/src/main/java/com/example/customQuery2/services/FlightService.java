package com.example.customQuery2.services;

import com.example.customQuery2.entities.FlightStatus;
import com.example.customQuery2.entities.Flight;
import com.example.customQuery2.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    public Flight createFlight(Flight flight) {
        return flightRepository.saveAndFlush(flight);
    }

    public List<Flight> findAllFlight() {
        return flightRepository.findAll();
    }


    //Ricerca ONTIME
    public List<Flight> searchOnTime() {
        return flightRepository.findByOnTime(FlightStatus.ONTIME);
    }

    //Creazione N elementi
    public List<Flight> populateListWithFlight(int n) {
        for (int i = 0; i < n; i++) {
            Random randomNumber = new Random();

            Integer int_description = randomNumber.nextInt(999999);
            Integer int_fromAirport = randomNumber.nextInt(999999);
            Integer int_toAirport = randomNumber.nextInt(999999);

            String descriptionString = int_description.toString();
            String fromAirportString = int_fromAirport.toString();
            String toAirportString = int_toAirport.toString();

            FlightStatus randomStatus = FlightStatus.values()[randomNumber.nextInt(FlightStatus.values().length)];

            Flight flight = new Flight((long) i, descriptionString, fromAirportString, toAirportString, randomStatus);

            flightRepository.saveAndFlush(flight);
        }
        return flightRepository.findAll();
    }

    //Ricerca tramite status
    public List<Flight> searchByStatus(String status) {
        return flightRepository.flightByStatus(status);
    }

    //Ricerca tramite doppio status
    public List<Flight> searchByDoubleStatus(String status, String status2) {
        return flightRepository.flightByDoubleStatus(status, status2);
    }

    //Lista ordinata di voli in ordine in base a fromAirport
    public List<Flight> listFlightFromAirport (){
        return flightRepository.flightOrderByFromAirport();
    }

    public boolean deleteAllData() {
        try {
            flightRepository.deleteAll();
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


}













