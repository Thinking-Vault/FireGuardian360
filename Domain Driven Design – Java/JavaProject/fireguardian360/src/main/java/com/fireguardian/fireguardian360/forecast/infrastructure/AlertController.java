package com.fireguardian.fireguardian360.forecast.infrastructure;

import com.fireguardian.fireguardian360.forecast.application.AlertService;
import com.fireguardian.fireguardian360.forecast.domain.model.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {
    @Autowired
    private AlertService alertService;

    @PostMapping
    public Alert create(@RequestBody Alert alert) {
        return alertService.createAlert(alert);
    }

    @GetMapping("/nearby")
    public List<Alert> getNearby(@RequestParam double lat, @RequestParam double lng, @RequestParam(defaultValue = "0.1") double radius) {
        return alertService.getNearbyAlerts(lat, lng, radius);
    }
}
