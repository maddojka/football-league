package com.soroko.footballleague.service;

import com.soroko.footballleague.repository.PlayerStatisticsRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatisticsService {
    private PlayerStatisticsRepository playerStatisticsRepository;

    public PlayerStatisticsService(PlayerStatisticsRepository playerStatisticsRepository) {
        this.playerStatisticsRepository = playerStatisticsRepository;
    }
}
