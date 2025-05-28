package com.fireguardian.fireguardian360.forecast.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.ZonedDateTime;


/**
 * Representa um alerta gerado pelo sistema, contendo informações sobre o usuário,
 * tipo de alerta (ex: "FOGO", "CHUVA"), nível de risco, localização geográfica e data de criação.
 * <p>
 * Fornece métodos utilitários para determinar se o alerta é considerado de alto risco com base em um limite.
 * </p>
 *
 * <p>Exemplo de uso:</p>
 * <pre>
 *     Alert alert = new Alert();
 *     boolean isHighRisk = alert.isHighRisk();
 * </pre>
 *
 */
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
     * Determina se o nível do alerta é considerado de alto risco com base no limite especificado.
     *
     * @param threshold o nível mínimo de alerta necessário para ser considerado de alto risco
     * @return {@code true} se o nível do alerta for maior ou igual ao limite; {@code false} caso contrário
     */
    public boolean isHighRisk(int threshold) {
        return this.level >= threshold;
    }


    
    /**
     * Determina se o alerta é considerado de alto risco usando o limite padrão.
     *
     * @return {@code true} se o alerta for de alto risco com base no limite padrão; {@code false} caso contrário.
     */
    public boolean isHighRisk() {
        return isHighRisk(5);
    }

    /**
     * Retorna uma representação em string do objeto Alert, incluindo seu id, tipo, nível
     * e localização (latitude e longitude) formatados com quatro casas decimais.
     *
     * @return uma string formatada descrevendo a instância de Alert
     */
    @Override
    public String toString() {
        return String.format("Alert[id=%d, type=%s, level=%d, loc=(%.4f,%.4f)]",
                id, type, level, lat, lng);
    }
}
