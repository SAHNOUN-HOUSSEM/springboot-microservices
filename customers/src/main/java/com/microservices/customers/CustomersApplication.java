package com.microservices.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.microservices.customers",
                "com.microservices.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.microservices.clients"
)
public class CustomersApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomersApplication.class, args);
    }
}
