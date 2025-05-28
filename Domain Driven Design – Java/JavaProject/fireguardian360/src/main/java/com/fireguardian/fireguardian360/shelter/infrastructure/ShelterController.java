package com.fireguardian.fireguardian360.shelter.infrastructure;

import com.fireguardian.fireguardian360.shelter.application.ShelterService;
import com.fireguardian.fireguardian360.shelter.domain.model.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelters")
public class ShelterController {
    @Autowired
    private ShelterService shelterService;

    @PostMapping
    public Shelter create(@RequestBody Shelter shelter) {
        return shelterService.createShelter(shelter);
    }

    @GetMapping("/nearby")
    public List<Shelter> getNearby(@RequestParam double lat, @RequestParam double lng, @RequestParam(defaultValue = "0.1") double radius) {
        return shelterService.getAvailableShelters(lat, lng, radius);
    }
}
