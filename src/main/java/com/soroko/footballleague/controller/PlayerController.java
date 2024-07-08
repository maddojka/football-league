package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/players")
public class PlayerController {
    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

  /*  @GetMapping("/form")
    public String getPlayerAddForm(Player player) {
        return "player/player-add-form";
    }*/

   /* @PostMapping
    public String addPlayer(@Valid Player player,
                                    BindingResult bindingResult,
                                    Model model) {
        return null;
    }*/
}
