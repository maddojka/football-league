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
public class PlayerController {
    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public String getAllPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "players";
    }

    @GetMapping("player/{id}")
    public String getPlayerById(@PathVariable long id, Model model) {
        Player player = playerService.getPlayerById(id);
        model.addAttribute("player_info", player);
        return "player";
    }

    @GetMapping("players/regplayer")
    public String getRegPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        return "regplayer";
    }

    @PostMapping()
    public String addPlayer(@ModelAttribute("player") @Valid Player player, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "/regplayer";
        playerService.addPlayer(player);
        return "redirect:/players" + playerService.addPlayer(player);
    }
}
