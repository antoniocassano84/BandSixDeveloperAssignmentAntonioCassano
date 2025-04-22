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

    private PriceAlertRepository repository;

    @PostMapping
    public ResponseEntity<PriceAlert> createAlert(@RequestBody PriceAlert alert) {
        PriceAlert savedAlert = repository.save(alert);
        return ResponseEntity.ok(savedAlert);
    }
}

