package com.microservices.customers;

import com.microservices.clients.frauds.FraudCheckResponse;
import com.microservices.clients.frauds.FraudsClient;
import com.microservices.clients.notifications.NotificationsClient;
import com.microservices.clients.notifications.SendNotificationDto;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(
        CustomersRepository customersRepository,
        FraudsClient fraudsClient,
        NotificationsClient notificationsClient
) {
    public void createCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .build();

        Customer savedCustomer = customersRepository.saveAndFlush(customer);
        Integer customerId = savedCustomer.getId();


        FraudCheckResponse fraudCheckResponse = fraudsClient.check(customerId);

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster detected");
        }

        SendNotificationDto sendNotificationDto = SendNotificationDto.builder()
                .customerId(customerId)
                .message("Customer created")
                .customerEmail(customerDto.email())
                .build();
        notificationsClient.sendNotification(sendNotificationDto);
    }
}
