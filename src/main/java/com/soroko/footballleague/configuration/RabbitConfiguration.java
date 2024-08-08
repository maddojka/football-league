package com.soroko.footballleague.configuration;

import lombok.Setter;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author yuriy.soroko
 */
@Configuration
@Setter
public class RabbitConfiguration {

    @Value("${queue.name}")
    private String queueName;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password")
    private String password;

    @Bean
    public Queue queue() {
        Queue queue = new Queue("paymentQueue", false);
        return queue;
    }
}
