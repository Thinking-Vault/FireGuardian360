package com.fireguardian.fireguardian360.forecast.application;

import com.fireguardian.fireguardian360.forecast.domain.model.Alert;
import com.fireguardian.fireguardian360.forecast.domain.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {
    @Autowired
    private AlertRepository alertRepository;

    public Alert createAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    public List<Alert> getNearbyAlerts(double lat, double lng, double radius) {
        return alertRepository.findByLatBetweenAndLngBetween(
                lat - radius, lat + radius,
                lng - radius, lng + radius
        );
    }
}
