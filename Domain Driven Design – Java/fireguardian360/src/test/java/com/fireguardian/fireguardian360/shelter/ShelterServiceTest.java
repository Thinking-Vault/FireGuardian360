package com.fireguardian.fireguardian360.shelter;

import com.fireguardian.fireguardian360.shelter.application.ShelterService;
import com.fireguardian.fireguardian360.shelter.domain.model.Shelter;
import com.fireguardian.fireguardian360.shelter.domain.repository.ShelterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShelterServiceTest {

    @Mock
    ShelterRepository repo;
    @InjectMocks
    ShelterService service;

    @Test
    void createShelter() {
        Shelter s = new Shelter();
        s.setName("A");
        when(repo.save(any())).thenReturn(s);

        Shelter out = service.createShelter(s);
        assertEquals("A", out.getName());
    }

    @Test
    void availableNearby() {
        when(repo.findAvailableNearby(0, 1, 0, 1))
                .thenReturn(List.of(new Shelter(), new Shelter()));
        var list = service.getAvailableShelters(0.5, 0.5, 0.5);
        assertEquals(2, list.size());
    }
}
