package com.nhsbsa.band6.antcs.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhsbsa.band6.antcs.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AlertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateProductAlert() throws Exception {
        Product product = new Product();
        product.setUrl("http://example.com/product");
        product.setTargetPrice(100.00);

        mockMvc.perform(post("/alerts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(objectMapper.writeValueAsString(product))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.productUrl").value("http://example.com/product"))
                .andExpect(jsonPath("$.targetPrice").value(100.00)));
    }
}
