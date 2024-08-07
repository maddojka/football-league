package com.soroko.footballleague.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class HomeControllerTest {


    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        HomeController homeController = new HomeController();
        mockMvc = MockMvcBuilders
                .standaloneSetup(homeController)
                .build();
    }

    @Test
    void homePage_StatusIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}