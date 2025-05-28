package com.fireguardian.fireguardian360.forecast;

import com.fireguardian.fireguardian360.forecast.application.AlertService;
import com.fireguardian.fireguardian360.forecast.domain.model.Alert;
import com.fireguardian.fireguardian360.forecast.infrastructure.AlertController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlertController.class)
class AlertControllerTest {

    @Autowired
    MockMvc mvc;
    @MockBean
    AlertService service;

    @Test
    void postAlertReturnsCreated() throws Exception {
        var json = """
                    { "userId":1, "type":"CHUVA", "level":8, "lat":-23.5, "lng":-46.6 }
                """;
        when(service.createAlert(any()))
                .thenReturn(new Alert() {{
                    setId(1L);
                    setType("CHUVA");
                }});

        mvc.perform(post("/alerts")
                        .contentType(APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.type").value("CHUVA"));
    }

    @Test
    void getNearbyAlertsWorks() throws Exception {
        when(service.getNearbyAlerts(0.0, 0.0, 0.1))
                .thenReturn(List.of(new Alert()));

        mvc.perform(get("/alerts/nearby")
                        .param("lat", "0.0")
                        .param("lng", "0.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}