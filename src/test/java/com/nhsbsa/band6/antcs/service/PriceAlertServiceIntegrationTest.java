package com.nhsbsa.band6.antcs.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.nhsbsa.band6.antcs.model.PriceAlert;
import com.nhsbsa.band6.antcs.repo.PriceAlertRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.List;

@SpringBootTest
public class PriceAlertServiceIntegrationTest {

    private final PriceAlertService service;
    private final PriceAlertRepository repository;
    private final JavaMailSender mailSender;

    public PriceAlertServiceIntegrationTest(PriceAlertRepository repository, JavaMailSender mailSender, PriceAlertService service) {
        this.repository = repository;
        this.mailSender = mailSender;
        this.service = service;
    }

    @Test
    public void testCheckPrices() {
        PriceAlert alert = new PriceAlert();
        alert.setProductUrl("http://example.com/product");
        alert.setTargetPrice(100.0);
        alert.setUserEmail("user@example.com");

        repository.save(alert);

        service.checkPrices();

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    public void testFetchCurrentPrice() {
        double price = service.fetchCurrentPrice();
        assertEquals(99.99, price);
    }
}

