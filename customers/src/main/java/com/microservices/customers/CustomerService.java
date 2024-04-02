package com.microservices.customers;

import org.springframework.stereotype.Service;

@Service
public record CustomerService (
        CustomersRepository customersRepository
){
    public void createCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .build();

        customersRepository.save(customer);
    }
}
