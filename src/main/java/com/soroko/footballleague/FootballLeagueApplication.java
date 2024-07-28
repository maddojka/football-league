package com.soroko.footballleague;

import com.soroko.footballleague.configuration.StorageProperties;
import com.soroko.footballleague.repository.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FootballLeagueApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballLeagueApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
