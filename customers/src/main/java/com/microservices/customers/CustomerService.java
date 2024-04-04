package com.microservices.customers;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService (
        CustomersRepository customersRepository,
        RestTemplate restTemplate
){
    public void createCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .build();

        Customer savedCustomer = customersRepository.saveAndFlush(customer);
        Integer customerId = savedCustomer.getId();


       FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/frauds/{customerId}",
                FraudCheckResponse.class,
               customerId
        );

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster detected");
        }
    }
}
