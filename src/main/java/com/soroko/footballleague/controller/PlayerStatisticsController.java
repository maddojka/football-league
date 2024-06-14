package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.PlayerStatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController("/playerstats")
public class PlayerStatisticsController {
    PlayerStatisticsService playerStatisticsService;

    public PlayerStatisticsController(PlayerStatisticsService playerStatisticsService) {
        this.playerStatisticsService = playerStatisticsService;
    }
}
