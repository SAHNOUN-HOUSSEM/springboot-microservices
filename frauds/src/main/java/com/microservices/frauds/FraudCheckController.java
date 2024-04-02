package com.microservices.frauds;

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
    public boolean check(
      @PathVariable("customerId") Integer customerId
    ){
        log.info("Checking customer {}", customerId);
        return fraudCheckService.check(customerId);
    }

}
