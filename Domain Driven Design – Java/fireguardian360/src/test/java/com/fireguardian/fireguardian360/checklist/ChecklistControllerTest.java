package com.fireguardian.fireguardian360.checklist;

import com.fireguardian.fireguardian360.checklist.application.ChecklistService;
import com.fireguardian.fireguardian360.checklist.domain.model.ChecklistItem;
import com.fireguardian.fireguardian360.checklist.infrastructure.ChecklistController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChecklistController.class)
class ChecklistControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    ChecklistService svc;

    @Test
    void getByUser() throws Exception {
        when(svc.getItemsByUser(1L))
                .thenReturn(List.of(new ChecklistItem() {{
                    setId(3L);
                    setLabel("M");
                    setStatus('P');
                }}));

        mvc.perform(get("/checklist/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[0].label").value("M"));
    }
}
