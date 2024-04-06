package com.microservices.notifications.rabbitmq;

import com.microservices.clients.notifications.SendNotificationDto;
import com.microservices.common.NotificationsQueueConfig;
import com.microservices.notifications.NotificationsService;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationsConsumer {

    private final NotificationsService notificationsService;


   @RabbitListener(queues = "${rabbitmq.queues.notification}")
   public void consume(SendNotificationDto sendNotificationDto){
        log.info("Consuming notification: {}", sendNotificationDto);
        notificationsService.sendNotification(sendNotificationDto);
    }

}
