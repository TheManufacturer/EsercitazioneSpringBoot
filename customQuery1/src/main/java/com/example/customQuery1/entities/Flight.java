package com.example.customQuery1.entities;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/*
@Builder //Utilizzata per la creazione di un design pattern Builder
*/
public class Flight {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String description;
    private String fromAirport;
    private String toAirport;

    //con .String su EnumType ci permette di prendere il nome su Enum
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;
}
