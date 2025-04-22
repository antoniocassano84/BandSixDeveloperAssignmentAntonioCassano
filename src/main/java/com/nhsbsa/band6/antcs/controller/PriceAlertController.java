package com.nhsbsa.band6.antcs.controller;

import com.nhsbsa.band6.antcs.model.PriceAlert;
import com.nhsbsa.band6.antcs.repo.PriceAlertRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alerts")
public class PriceAlertController {

    private final PriceAlertRepository repository;

    public PriceAlertController(PriceAlertRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<String> createAlert(@RequestBody PriceAlert alert) {
        repository.save(alert);
        return ResponseEntity.ok("Alert set successfully for product: " + alert);
    }

}

