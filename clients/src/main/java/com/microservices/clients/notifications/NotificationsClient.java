package com.microservices.clients.notifications;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "notification",
        path = "/api/v1/notifications"
)
public interface NotificationsClient {
    @PostMapping("")
    void sendNotification(
            @RequestBody SendNotificationDto sendNotificationDto
    );
}
