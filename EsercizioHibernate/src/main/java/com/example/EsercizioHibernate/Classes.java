package com.example.EsercizioHibernate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

}

/*
la tabella classes dove ogni classe ha:
primary key
title (not null)
description (not null)
 */