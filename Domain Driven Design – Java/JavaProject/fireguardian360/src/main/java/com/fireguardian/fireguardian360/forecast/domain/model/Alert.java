package com.fireguardian.fireguardian360.forecast.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    /**
     * Retorna true se o nível do alerta excede o threshold.
     *
     * @param threshold nível mínimo para alto risco.
     * @return boolean indicando alto risco.
     */
    public boolean isHighRisk(int threshold) {
        return this.level >= threshold;
    }

    /**
     * Versão sobrecarregada: considera threshold padrão (5).
     *
     * @return boolean indicando alto risco.
     */
    public boolean isHighRisk() {
        return isHighRisk(5);
    }

    @Override
    public String toString() {
        return String.format("Alert[id=%d, type=%s, level=%d, loc=(%.4f,%.4f)]",
                id, type, level, lat, lng);
    }
}
