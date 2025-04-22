package com.nhsbsa.band6.antcs.controller;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.nhsbsa.band6.antcs.model.PriceAlert;
import com.nhsbsa.band6.antcs.repo.PriceAlertRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PriceAlertController.class)
public class PriceAlertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceAlertRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateAlert() throws Exception {
        PriceAlert alert = new PriceAlert();
        alert.setProductUrl("http://example.com/product");
        alert.setTargetPrice(100.0);
        alert.setUserEmail("user@example.com");

        when(repository.save(any(PriceAlert.class))).thenReturn(alert);

        mockMvc.perform(post("/api/alerts")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(alert)))
                .andExpect(status().isOk())
                .andExpect(content().string("Alert set successfully for product: http://example.com/product"));
    }
}
