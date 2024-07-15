package com.soroko.footballleague.configuration;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@EnableScheduling
public class ScheduledTasks {

    @Async("football-league-executor")
    @Scheduled(fixedRate = 7, timeUnit = TimeUnit.DAYS)
    public void scheduledTask() {

    }
}
