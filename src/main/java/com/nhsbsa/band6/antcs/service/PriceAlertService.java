package com.nhsbsa.band6.antcs.service;

import com.nhsbsa.band6.antcs.model.PriceAlert;
import com.nhsbsa.band6.antcs.repo.PriceAlertRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceAlertService {

    private final PriceAlertRepository repository;
    private final JavaMailSender mailSender;

    public PriceAlertService(PriceAlertRepository repository, JavaMailSender mailSender) {
        this.repository = repository;
        this.mailSender = mailSender;
    }

    public void checkPrices() {
        // Simulate fetching product prices from a static JSON
        double currentPrice = fetchCurrentPrice();

        List<PriceAlert> alerts = repository.findAll();
//        for (PriceAlert alert : alerts) {
//            if (currentPrice <= alert.getTargetPrice()) {
//                sendEmail(alert.getUserEmail(), alert.getProductUrl(), currentPrice);
//            }
//        }
    }

    double fetchCurrentPrice() {
        // Simulate fetching price from a static JSON
        return 99.99; // Example price
    }

    private void sendEmail(String to, String productUrl, double currentPrice) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Price Drop Alert");
        message.setText("The price for the product at " + productUrl + " has dropped to " + currentPrice);
        mailSender.send(message);
    }
}

