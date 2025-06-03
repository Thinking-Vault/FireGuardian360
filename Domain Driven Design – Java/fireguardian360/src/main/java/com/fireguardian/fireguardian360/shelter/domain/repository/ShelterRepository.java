package com.fireguardian.fireguardian360.shelter.domain.repository;

import com.fireguardian.fireguardian360.shelter.domain.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Repositório para operações de acesso a dados relacionadas à entidade Shelter.
 * Estende JpaRepository para fornecer operações CRUD padrão.
 *
 * Métodos personalizados:
 * - findAvailableNearby: Busca abrigos disponíveis dentro de uma área geográfica especificada por limites de latitude e longitude,
 *   retornando apenas aqueles com capacidade disponível maior que zero.
 */
public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    /**
     * Encontra uma lista de abrigos disponíveis dentro dos limites especificados de latitude e longitude.
     * Apenas abrigos com capacidade disponível maior que zero são retornados.
     *
     * @param latMin a latitude mínima da área de busca
     * @param latMax a latitude máxima da área de busca
     * @param lngMin a longitude mínima da área de busca
     * @param lngMax a longitude máxima da área de busca
     * @return uma lista de abrigos disponíveis dentro dos limites geográficos especificados
     */
    @Query("SELECT s FROM Shelter s WHERE s.lat BETWEEN :latMin AND :latMax AND s.lng BETWEEN :lngMin AND :lngMax AND s.available > 0")
    List<Shelter> findAvailableNearby(@Param("latMin") double latMin,
                                      @Param("latMax") double latMax,
                                      @Param("lngMin") double lngMin,
                                      @Param("lngMax") double lngMax);
}
