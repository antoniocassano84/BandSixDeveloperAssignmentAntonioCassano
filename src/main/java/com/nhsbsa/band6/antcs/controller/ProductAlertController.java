package com.nhsbsa.band6.antcs.controller;

import com.nhsbsa.band6.antcs.model.ProductAlert;
import com.nhsbsa.band6.antcs.service.ProductAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alerts")
public class ProductAlertController {

    private final ProductAlertService service;

    public ProductAlertController(ProductAlertService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductAlert> createAlert(@RequestBody ProductAlert alert) {
        ProductAlert savedAlert = service.saveAlert(alert);
        return ResponseEntity.ok(savedAlert);
    }

    @GetMapping("/check")
    public ResponseEntity<Void> checkAlerts() {
        service.checkPriceDrop();
        return ResponseEntity.ok().build();
    }
}

