package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.MatchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
class MatchControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private MatchService matchService;

    @Autowired
    private MatchController matchController;

    @BeforeEach
    public void setUp() {
        matchController = new MatchController(matchService);
        mockMvc = MockMvcBuilders
                .standaloneSetup(matchController)
                .build();
    }

    @Test
    void matchesPage_StatusIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/matches"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}