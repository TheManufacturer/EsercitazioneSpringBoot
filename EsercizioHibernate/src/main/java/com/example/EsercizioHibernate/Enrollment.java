package com.example.EsercizioHibernate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    //@JoinColumn(name = "student_id" , nullable = false)
    private Student student;

    @ManyToOne
    //@JoinColumn(name = "class_id", nullable = false)
    private Classes classes;

}

/*
tabella enrollments per salvare collegamenti tra le tabelle students e classes:
    primary key
    2 foreign keys
 */