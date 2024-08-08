package com.soroko.footballleague.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuriy.soroko
 */
@Configuration
public class KafkaConfiguration {
    @Bean
    public NewTopic newTopic() {
        return new NewTopic("matchweek", 1, (short) 1);
    }
}
