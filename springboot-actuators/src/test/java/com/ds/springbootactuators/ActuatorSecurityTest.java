package com.ds.springbootactuators;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class ActuatorSecurityTest {

	@Autowired
	private MockMvc mockMvc;
	

	
	@Test
    void checkInfoEndpoint() throws Exception {
        mockMvc.perform(get("/actuator/info"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }
 
    @Test
    void checkHealthEndpoint() throws Exception {
        mockMvc.perform(get("/actuator/health"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"status\": \"UP\"}"));
    }
 
    @Test
    void checkEnvEndpointUnauthenticated() throws Exception {
        mockMvc.perform(get("/actuator/env"))
                .andExpect(status().isUnauthorized());
    }
 
    @Test
    @WithMockUser(username = "user")
    void checkShutdownEndpoint() throws Exception {
        mockMvc.perform(get("/actuator/shutdown"))
                .andExpect(status().isNotFound());
    }
 
    @ParameterizedTest
    @ValueSource(strings = {"env", "metrics", "beans", "loggers", "configprops", "mappings"})
    @WithMockUser(username = "user")
    void checkAuthenticatedEndpoints(String url) throws Exception {
        mockMvc.perform(get("/actuator/" + url))
                .andExpect(status().isOk());
    }
}
