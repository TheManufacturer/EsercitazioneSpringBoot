package com.example.interceptor02.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Month {
    private Integer monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;
}
