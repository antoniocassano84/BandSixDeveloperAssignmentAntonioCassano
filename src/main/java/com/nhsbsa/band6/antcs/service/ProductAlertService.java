package com.nhsbsa.band6.antcs.service;

import com.nhsbsa.band6.antcs.model.ProductAlert;
import com.nhsbsa.band6.antcs.repo.ProductAlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAlertService {

    private final ProductAlertRepository repository;

    public ProductAlertService(ProductAlertRepository repository) {
        this.repository = repository;
    }

    public void checkPriceDrop() {
        // Fetch static JSON (simulated)
        double currentPrice = fetchCurrentPrice();

        // Check price conditions and notify users
        List<ProductAlert> alerts = repository.findAll();
//        for (ProductAlert alert : alerts) {
//            if (currentPrice <= alert.getTargetPrice()) {
//                notifyUser(alert);
//            }
//        }
    }

    private double fetchCurrentPrice() {
        // Simulate fetching price from JSON
        return 100.0; // Example static price
    }

    private void notifyUser(ProductAlert alert) {
        // Simulate notification logic
//        System.out.println("Price drop alert for: " + alert.getProductUrl());
    }

    public ProductAlert saveAlert(ProductAlert alert) {
        return new ProductAlert();
    }
}

