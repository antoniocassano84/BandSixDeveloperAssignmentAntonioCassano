package com.nhsbsa.band6.antcs.repo;

import static org.junit.jupiter.api.Assertions.*;

import com.nhsbsa.band6.antcs.model.PriceAlert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PriceAlertRepositoryTest {

    @Autowired
    private PriceAlertRepository repository;

    @Test
    void testSaveAndFind() {
        PriceAlert alert = new PriceAlert();
        alert.setProductUrl("http://example.com/product");
        alert.setTargetPrice(100.0);
        alert.setUserEmail("user@example.com");

        PriceAlert savedAlert = repository.save(alert);
        assertNotNull(savedAlert.getId());

        PriceAlert foundAlert = repository.findById(savedAlert.getId()).orElse(null);
        assertNotNull(foundAlert);
        assertEquals("http://example.com/product", foundAlert.getProductUrl());
    }
}
