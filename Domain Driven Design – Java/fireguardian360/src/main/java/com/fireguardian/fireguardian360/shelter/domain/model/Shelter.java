package com.fireguardian.fireguardian360.shelter.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double lat;
    private double lng;
    private int capacity;
    private int available;
}