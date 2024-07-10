package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.service.PlayerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/players")
public class PlayerController {
    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String getAllPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "players";
    }

    @GetMapping("/{id}")
    public String getPlayerById(@PathVariable int id, Model model) {
        Player player = playerService.getPlayerById(id);
        model.addAttribute("player_info", player);
        // doctor_info - ссылка на doctor из html
        return "players/player";
    }
   /* @PostMapping
    public String addPlayer(@Valid Player player,
                                    BindingResult bindingResult,
                                    Model model) {
        return null;
    }*/
}
