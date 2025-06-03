package com.fireguardian.fireguardian360.forecast;

import com.fireguardian.fireguardian360.forecast.application.AlertService;
import com.fireguardian.fireguardian360.forecast.domain.model.Alert;
import com.fireguardian.fireguardian360.forecast.domain.repository.AlertRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlertServiceTest {

    @Mock
    private AlertRepository repo;

    @InjectMocks
    private AlertService service;

    @Test
    void shouldCreateAndReturnAlert() {
        Alert input = new Alert();
        input.setType("FOGO");
        when(repo.save(any())).thenAnswer(inv -> {
            Alert a = inv.getArgument(0);
            a.setId(123L);
            return a;
        });

        Alert result = service.createAlert(input);
        assertNotNull(result.getId());
        assertEquals("FOGO", result.getType());
    }

    @Test
    void shouldReturnNearbyAlerts() {
        List<Alert> mockList = List.of(new Alert(), new Alert());
        when(repo.findByLatBetweenAndLngBetween(
                eq(10.0), eq(20.0), eq(30.0), eq(40.0)))
                .thenReturn(mockList);

        var out = service.getNearbyAlerts(15.0, 35.0, 5.0);
        assertEquals(2, out.size());
    }
}