package com.example.customQuery2.repositories;

import com.example.customQuery2.entities.Flight;
import com.example.customQuery2.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("select f from Flight f where f.status = ONTIME")
    List<Flight> findByOnTime(FlightStatus ONTIME);

    //Query su ricerca per 'status'
    @Query(value = "select * from flight f where f.status = ?1", nativeQuery = true)
    List<Flight> flightByStatus(String status);


    //Query su ricerca per doppio 'status'
    @Query(value = "select * from flight f where f.status = ?1 or f.status = ?2", nativeQuery = true)
    List<Flight> flightByDoubleStatus(String status, String status2);

    //Query per tutti i voli ma in modo ascendende in base a 'fromAirport' in lista
    @Query(value = ("select * from flight f order by f.from_Airport"),nativeQuery = true)
    List<Flight> flightOrderByFromAirport();

}
