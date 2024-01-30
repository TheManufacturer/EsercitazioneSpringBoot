package com.example.EsercizioHibernate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

}
/*
la tabella students dove ogni studente avrà:
    primary key
    colonna lastName (not null)
    colonna firstName (not null)
    colonna email con valori univoci e not null*/