package com.nhsbsa.band6.antcs.repo;

import com.nhsbsa.band6.antcs.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> { }

