package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.PlayerStatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PlayerStatisticsController {
    PlayerStatisticsService playerStatisticsService;

    public PlayerStatisticsController(PlayerStatisticsService playerStatisticsService) {
        this.playerStatisticsService = playerStatisticsService;
    }

    @GetMapping("/playerstat")
    public String teamstat(Model model) {
        return null;
    }
}
