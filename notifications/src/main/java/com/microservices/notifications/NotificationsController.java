package com.microservices.notifications;

import com.microservices.clients.notifications.SendNotificationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/notifications")
public record NotificationsController (
        NotificationsService notificationsService
){
    @PostMapping("")
    public void sendNotification(
            @RequestBody SendNotificationDto sendNotificationDto
    ){
        log.info("Sending notification for customer with id: {}", sendNotificationDto.customerId());
        notificationsService.sendNotification(sendNotificationDto);
    }
}
