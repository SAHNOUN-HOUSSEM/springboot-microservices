package com.microservices.frauds;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudHistoryRepository fraudHistoryRepository;

    public boolean check(Integer customerId) {
        return false;
    }
}
