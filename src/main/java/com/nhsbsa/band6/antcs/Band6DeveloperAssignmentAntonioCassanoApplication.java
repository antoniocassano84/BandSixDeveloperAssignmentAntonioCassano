package com.nhsbsa.band6.antcs;

import com.nhsbsa.band6.antcs.model.Product;
import com.nhsbsa.band6.antcs.repo.ProductRepository;
import com.nhsbsa.band6.antcs.service.EmailService;
import com.nhsbsa.band6.antcs.service.PriceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;


@EnableScheduling
@SpringBootApplication
public class Band6DeveloperAssignmentAntonioCassanoApplication {

    private final ProductRepository productRepository;
    private final PriceService priceService;
    private final EmailService emailService;

    public Band6DeveloperAssignmentAntonioCassanoApplication(ProductRepository productRepository, PriceService priceService, EmailService emailService) {
        this.productRepository = productRepository;
        this.priceService = priceService;
        this.emailService = emailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Band6DeveloperAssignmentAntonioCassanoApplication.class, args);
    }

    @Scheduled(fixedRate = 3600000) // Check every hour
    public void checkPrices() {
        List<Product> products = productRepository.findAll();
        if(!products.isEmpty()) {
            for (Product product : products) {
                double currentPrice = priceService.fetchCurrentPrice(product.getUrl());
                if (currentPrice <= product.getTargetPrice()) {
                    emailService.sendPriceDropAlert(product.getEmail(), product.getUrl(), currentPrice);
                }
            }
        }
    }
}


