package com.nhsbsa.band6.antcs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nhsbsa.band6.antcs.model.PriceAlert;
import com.nhsbsa.band6.antcs.repo.PriceAlertRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import java.util.List;

public class PriceAlertServiceTest {

    @MockBean
    private PriceAlertRepository repository;

    @MockBean
    private JavaMailSender mailSender;

    @InjectMocks
    private PriceAlertService service;

    public PriceAlertServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCheckPrices() {
        PriceAlert alert = new PriceAlert();
        alert.setProductUrl("http://example.com/product");
        alert.setTargetPrice(100.0);
        alert.setUserEmail("user@example.com");

        List<PriceAlert> alerts = List.of(alert);
        when(repository.findAll()).thenReturn(alerts);

        service.checkPrices();

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    void testFetchCurrentPrice() {
        double price = service.fetchCurrentPrice();
        assertEquals(99.99, price);
    }
}
