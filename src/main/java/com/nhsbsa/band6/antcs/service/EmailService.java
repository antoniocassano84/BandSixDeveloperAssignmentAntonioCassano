package com.nhsbsa.band6.antcs.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendPriceDropAlert(String to, String productUrl, double currentPrice) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Price Drop Alert");
        message.setText("The price for the product at " + productUrl + " has dropped to " + currentPrice);
        mailSender.send(message);
    }
}


