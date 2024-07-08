package com.soroko.footballleague;

import com.soroko.footballleague.profiles.SettingsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableConfigurationProperties(SettingsService.class)
@ComponentScan(basePackages = {"com.soroko.footballleague"})
public class FootballLeagueApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballLeagueApplication.class, args);
    }

}
