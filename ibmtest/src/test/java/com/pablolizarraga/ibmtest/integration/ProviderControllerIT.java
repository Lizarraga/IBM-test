package com.pablolizarraga.ibmtest.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pablolizarraga.ibmtest.controller.ProviderController;
import com.pablolizarraga.ibmtest.repository.ProviderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProviderControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProviderRepository providerRepository;

    @Test
    public void givenExistingClientId_whenGetByClientId_thenReturnProvidersList() throws Exception {
        //given - precondition or setup
        Long clientId = 1L;

        //when
        ResultActions response = mockMvc.perform(
                get(ProviderController.ROOT_PATH + ProviderController.CLIENT_ID_PATH, clientId)
        );

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    public void givenNonExistingClientId_whenGetByClientId_thenReturnEmptyList() throws Exception {
        //given - precondition or setup
        Long clientId = -1L;

        //when
        ResultActions response = mockMvc.perform(
                get(ProviderController.ROOT_PATH + ProviderController.CLIENT_ID_PATH, clientId)
        );

        //then
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

}
