package com.nhsbsa.band6.antcs.repo;

import com.nhsbsa.band6.antcs.model.PriceAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceAlertRepository extends JpaRepository<PriceAlert, Long> {
}

