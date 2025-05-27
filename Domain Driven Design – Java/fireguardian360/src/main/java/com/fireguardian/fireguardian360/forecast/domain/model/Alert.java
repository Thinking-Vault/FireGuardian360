package com.fireguardian.fireguardian360.forecast.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String type; // ex: "FOGO", "CHUVA"
    private int level;
    private double lat;
    private double lng;
    private ZonedDateTime createdAt = ZonedDateTime.now();
}
