package com.microservices.notifications;

import com.microservices.amqp.RabbitMQMessageProducer;
import com.microservices.common.NotificationsQueueConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.microservices.notifications",
                "com.microservices.amqp",
                "com.microservices.common"
        }
)
@EnableEurekaClient
public class NotificationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationsApplication.class, args);
    }


    /*
    @Bean
    CommandLineRunner commandLineRunner(
            RabbitMQMessageProducer producer,
            NotificationsQueueConfig notificationsQueueConfig
            ) {
        return args -> {
            producer.publish(
                new Person("Ali", 18),
                notificationsQueueConfig.getInternalExchange(),
                    notificationsQueueConfig.getInternalNotificationRoutingKey()
            );
        };
    }

    record Person(String name, int age){}

     */

}
