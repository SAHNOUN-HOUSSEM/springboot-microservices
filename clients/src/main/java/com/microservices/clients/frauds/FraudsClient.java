package com.microservices.clients.frauds;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "fraud",
        path = "/api/v1/frauds"
)
public interface FraudsClient {

    @GetMapping("/{customerId}")
    public FraudCheckResponse check(
            @PathVariable("customerId") Integer customerId
    );
}
