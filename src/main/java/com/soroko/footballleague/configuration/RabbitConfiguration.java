package com.soroko.footballleague.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author yuriy.soroko
 */
@Configuration
public class RabbitConfiguration {
    @Bean
    public Queue queue() {
        return new Queue("FirstQueue", false);
    }
}
