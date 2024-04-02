package com.microservices.customers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public record CustomersController (
        CustomerService customerService
) {

    @PostMapping()
    public void createCustomer(
            @RequestBody CustomerDto customerDto
    ) {
        log.info("Creating a new customer {}", customerDto);
        customerService.createCustomer(customerDto);
    }
}
