package com.nhsbsa.band6.antcs.service;

import org.springframework.stereotype.Service;

@Service
public class PriceService {
    public double fetchCurrentPrice(String url) {
        // Mock implementation: Fetch price from static JSON
        // In a real application, you would fetch the price from the actual product page
        return 100.0; // Example price
    }
}

