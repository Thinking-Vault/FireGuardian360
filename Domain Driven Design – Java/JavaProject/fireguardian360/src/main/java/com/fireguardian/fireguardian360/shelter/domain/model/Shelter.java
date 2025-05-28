package com.fireguardian.fireguardian360.shelter.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    /**
     * Calcula a taxa de ocupação atual do abrigo.
     *
     * @return relação occupied/capacity como porcentagem.
     */
    public double getOccupancyRate() {
        return (double) (capacity - available) / capacity * 100;
    }

    @Override
    public String toString() {
        return name + " [" + available + "/" + capacity + "]";
    }
}