package com.nhsbsa.band6.antcs.repo;

import com.nhsbsa.band6.antcs.model.ProductAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAlertRepository extends JpaRepository<ProductAlert, Long> {
}
