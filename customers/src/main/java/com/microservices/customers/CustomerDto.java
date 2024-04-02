package com.microservices.customers;

public record CustomerDto(
        String firstName,
        String lastName,
        String email
) {
}
