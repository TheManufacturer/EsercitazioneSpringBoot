package com.example.customQuery2.entities;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    private Long id;

    private String description;
    private String fromAirport;
    private String toAirport;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

}
