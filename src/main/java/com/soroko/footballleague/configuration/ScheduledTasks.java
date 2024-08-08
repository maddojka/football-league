package com.soroko.footballleague.configuration;

import com.soroko.footballleague.service.kafka.KafkaProducer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@EnableScheduling
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduledTasks {

    final KafkaProducer kafkaProducer;

    @Async("football-league-executor")
    @Scheduled(fixedRate = 7, timeUnit = TimeUnit.DAYS)
    public void scheduledTask() {
        kafkaProducer.sendMessage("Don't miss new football week!");
    }
}
