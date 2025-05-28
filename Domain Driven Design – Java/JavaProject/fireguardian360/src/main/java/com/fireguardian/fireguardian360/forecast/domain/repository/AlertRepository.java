package com.fireguardian.fireguardian360.forecast.domain.repository;

import com.fireguardian.fireguardian360.forecast.domain.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByLatBetweenAndLngBetween(double latMin, double latMax, double lngMin, double lngMax);
}
