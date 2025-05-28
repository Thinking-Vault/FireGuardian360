package com.fireguardian.fireguardian360.shelter;

import com.fireguardian.fireguardian360.shelter.application.ShelterService;
import com.fireguardian.fireguardian360.shelter.domain.model.Shelter;
import com.fireguardian.fireguardian360.shelter.infrastructure.ShelterController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShelterController.class)
class ShelterControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    ShelterService svc;

    @Test
    void postShelter() throws Exception {
        String json = """
                    { "name":"X", "lat":0, "lng":0, "capacity":10, "available":5 }
                """;
        Shelter shelter = new Shelter();
        shelter.setId(2L);
        shelter.setName("X");
        when(svc.createShelter(any())).thenReturn(shelter);

        mvc.perform(post("/shelters")
                        .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("X"));
    }
}