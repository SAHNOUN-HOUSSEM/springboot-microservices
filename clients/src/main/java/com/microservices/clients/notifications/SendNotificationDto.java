package com.microservices.clients.notifications;

import lombok.Builder;

@Builder
public record SendNotificationDto(
        Integer customerId,
        String message,
        String customerEmail
) {
}
