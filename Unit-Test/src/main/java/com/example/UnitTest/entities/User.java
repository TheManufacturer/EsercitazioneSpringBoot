package com.example.Unittest.Entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table

public class UserS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private boolean isWorking;
}
