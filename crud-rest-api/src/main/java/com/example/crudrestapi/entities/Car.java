package com.example.crudrestapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelName;


    @Column(nullable = false)
    private String serialNumber;


    //@Column(nullable = true)
    private Double currentPrice;
}

/*
crea la tabella di macchine cars, dove ogni entità Car ha:
primary key
modelName not null
serialNumber not null
currentPrice che può essere null
 */