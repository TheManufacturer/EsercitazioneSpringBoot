package com.example.customQuery1.repositories;

import com.example.customQuery1.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    //@Query("select f from Flight f where f.status = ?ONTIME") --> risulta non funzionante.

    @Query(value = "SELECT * FROM Flight f WHERE f.flight_status like :status", nativeQuery = true)
    List<Flight> searchFlights(String status); // qui la generalizzazione su status

    @Query(value = "SELECT * FROM Flight f WHERE f.from_airport like :airport", nativeQuery = true)
    List<Flight> searchByDeparture(String airport);
}
