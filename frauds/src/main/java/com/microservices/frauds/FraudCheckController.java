package com.microservices.frauds;

import com.microservices.clients.frauds.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/frauds")
@AllArgsConstructor
@Slf4j
public class FraudCheckController {
    private  final  FraudCheckService fraudCheckService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse check(
      @PathVariable("customerId") Integer customerId
    ){
        log.info("Fraud check requested for customer {}", customerId);
        boolean isFraudster= fraudCheckService.check(customerId);
        return  new FraudCheckResponse(isFraudster);
    }

}
