package com.fireguardian.fireguardian360.forecast.domain.repository;

import com.fireguardian.fireguardian360.forecast.domain.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Interface AlertRepository que estende JpaRepository para fornecer operações de persistência para a entidade Alert.
 * 
 * Este repositório inclui um método personalizado para recuperar alertas com base em coordenadas geográficas.
 * 
 * Métodos:
 * - findByLatBetweenAndLngBetween: Recupera uma lista de entidades Alert cujas coordenadas de latitude e longitude
 *   estão dentro de intervalos especificados.
 * 
 * @see JpaRepository
 * @see Alert
 */
public interface AlertRepository extends JpaRepository<Alert, Long> {

    /**
     * Recupera uma lista de entidades Alert cujos valores de latitude e longitude estão dentro dos intervalos especificados.
     *
     * @param latMin o valor mínimo de latitude (inclusive)
     * @param latMax o valor máximo de latitude (inclusive)
     * @param lngMin o valor mínimo de longitude (inclusive)
     * @param lngMax o valor máximo de longitude (inclusive)
     * @return uma lista de objetos Alert localizados dentro dos limites de latitude e longitude especificados
     */
    List<Alert> findByLatBetweenAndLngBetween(double latMin, double latMax, double lngMin, double lngMax);
}
