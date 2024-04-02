package com.microservices.frauds;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
