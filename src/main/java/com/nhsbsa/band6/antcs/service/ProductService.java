package com.nhsbsa.band6.antcs.service;

import com.nhsbsa.band6.antcs.model.Product;
import com.nhsbsa.band6.antcs.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> checkPriceDrops() {
        List<Product> products = productRepository.findAll();
        List<Product> priceDroppedProducts = new ArrayList<>();

        for (Product product : products) {
            double currentPrice = fetchCurrentPrice(product.getUrl());
            if (currentPrice <= product.getTargetPrice()) {
                priceDroppedProducts.add(product);
            }
        }

        return priceDroppedProducts;
    }

    private double fetchCurrentPrice(String url) {
        // Simulate fetching current price from a static JSON
        return 100.0; // Replace with actual logic
    }
}

