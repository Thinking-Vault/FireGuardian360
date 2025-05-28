package com.fireguardian.fireguardian360.shelter.domain.repository;

import com.fireguardian.fireguardian360.shelter.domain.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
    @Query("SELECT s FROM Shelter s WHERE s.lat BETWEEN :latMin AND :latMax AND s.lng BETWEEN :lngMin AND :lngMax AND s.available > 0")
    List<Shelter> findAvailableNearby(@Param("latMin") double latMin,
                                      @Param("latMax") double latMax,
                                      @Param("lngMin") double lngMin,
                                      @Param("lngMax") double lngMax);
}
