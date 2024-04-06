package com.microservices.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class RabbitMQConfig {

    private final ConnectionFactory connectionFactory;

    //what does AmqpTemplate do?
    //AmqpTemplate is the interface that defines the basic set of AMQP operations.
    //It provides methods for sending and receiving messages.
    //The AmqpTemplate interface is implemented by the RabbitTemplate class.
    //RabbitTemplate is a class that provides methods for sending and receiving messages.
    //It is a high-level abstraction for sending and receiving messages.
    @Bean
    public AmqpTemplate amqpTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jacksonConverter());
        return rabbitTemplate;
    }


    //what does SimpleRabbitListenerContainerFactory do?
    //SimpleRabbitListenerContainerFactory is a factory for creating SimpleMessageListenerContainer instances.
    //SimpleMessageListenerContainer is a class that provides a simple message listener container.
    //It is a container for message listeners that listens for messages on a RabbitMQ queue.
    //SimpleMessageListenerContainer is a class that provides a simple message listener container.
    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jacksonConverter());
        return factory;
    }


    //what does MessageConverter do?
    //MessageConverter is an interface that defines the methods for converting messages.
    //It provides methods for converting messages to and from byte arrays.
    //The MessageConverter interface is implemented by the Jackson2JsonMessageConverter class.
    //Jackson2JsonMessageConverter is a class that provides methods for converting messages to and from JSON.
    //It is a message converter that converts messages to and from JSON.
    @Bean
    public MessageConverter jacksonConverter() {
        MessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        return jackson2JsonMessageConverter;
    }

}