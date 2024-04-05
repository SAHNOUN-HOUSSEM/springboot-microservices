package com.microservices.customers;

import com.microservices.clients.frauds.FraudCheckResponse;
import com.microservices.clients.frauds.FraudsClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService (
        CustomersRepository customersRepository,
        RestTemplate restTemplate,
        FraudsClient fraudsClient
){
    public void createCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .build();

        Customer savedCustomer = customersRepository.saveAndFlush(customer);
        Integer customerId = savedCustomer.getId();


       FraudCheckResponse fraudCheckResponse =  fraudsClient.check(customerId);

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster detected");
        }
    }
}
