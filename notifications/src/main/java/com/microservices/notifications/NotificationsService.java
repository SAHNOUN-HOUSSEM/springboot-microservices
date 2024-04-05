package com.microservices.notifications;

import com.microservices.clients.notifications.SendNotificationDto;
import org.springframework.stereotype.Service;

@Service
public record NotificationsService(
NotificationsRepository notificationsRepository
) {
    public void sendNotification(SendNotificationDto sendNotificationDto){

        Notification notification =  Notification.builder()
                .message(sendNotificationDto.message())
                .customerId(sendNotificationDto.customerId())
                .customerEmail(sendNotificationDto.customerEmail())
                .sentAt(java.time.LocalDateTime.now())
                .build();
        notificationsRepository.save(notification);
    }
}
