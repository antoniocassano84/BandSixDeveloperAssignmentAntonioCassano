package com.nhsbsa.band6.antcs.controller;

import com.nhsbsa.band6.antcs.model.Product;
import com.nhsbsa.band6.antcs.repo.ProductRepository;
import com.nhsbsa.band6.antcs.service.EmailService;
import com.nhsbsa.band6.antcs.service.PriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final ProductRepository productRepository;
    private final PriceService priceService;
    private final EmailService emailService;

    public AlertController(ProductRepository productRepository, PriceService priceService, EmailService emailService) {
        this.productRepository = productRepository;
        this.priceService = priceService;
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Product> createAlert(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkPrices() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            double currentPrice = priceService.fetchCurrentPrice(product.getUrl());
            if (currentPrice <= product.getTargetPrice()) {
                emailService.sendPriceDropAlert(product.getEmail(), product.getUrl(), currentPrice);
            }
        }
        return ResponseEntity.ok("Price check completed");
    }
}


