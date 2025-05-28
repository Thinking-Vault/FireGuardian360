package com.fireguardian.fireguardian360.shelter.application;

import com.fireguardian.fireguardian360.shelter.domain.model.Shelter;
import com.fireguardian.fireguardian360.shelter.domain.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterService {
    @Autowired
    private ShelterRepository shelterRepository;

    public Shelter createShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }

    public List<Shelter> getAvailableShelters(double lat, double lng, double radius) {
        return shelterRepository.findAvailableNearby(
                lat - radius, lat + radius,
                lng - radius, lng + radius
        );
    }
}
