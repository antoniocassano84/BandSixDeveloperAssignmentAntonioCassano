package com.nhsbsa.band6.antcs.config;

import com.nhsbsa.band6.antcs.service.PriceAlertService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {

    private final PriceAlertService service;

    public SchedulingConfig(PriceAlertService service) {
        this.service = service;
    }

    @Scheduled(fixedRate = 3600000) // Check every hour
    public void schedulePriceCheck() {
        service.checkPrices();
    }
}

