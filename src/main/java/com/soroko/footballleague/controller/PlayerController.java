package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.PlayerService;
import org.springframework.web.bind.annotation.RestController;


@RestController("/players")
public class PlayerController {
    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
}
