package com.movemate.health;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(HealthController.class)//loads the MVC components needed to test this controller without starting the entire application or connecting to MySQL.
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnHealthyResponse() throws Exception {
        mockMvc.perform(get("/api/v1/health"))//mockMvc.perform(get(...)) simulates an HTTP GET request.
                .andExpect(status().isOk())//status().isOk() checks that the endpoint returns HTTP 200.
                .andExpect(jsonPath("$.application").value("MoveMate"))  //jsonPath(...) checks the values in the JSON response.
                .andExpect(jsonPath("$.status").value("UP"));
    }
}	
	

