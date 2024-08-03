package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.repository.PlayerRepository;
import com.soroko.footballleague.service.PlayerService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerController {
    final PlayerService playerService;

    @GetMapping("/players")
    public String getAllPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "players";
    }

    @GetMapping("/player/{id}")
    public String getPlayerById(@PathVariable long id, Model model) {
        Player player = playerService.getPlayerById(id);
        model.addAttribute("player_info", player);
        return "player";
    }

    @GetMapping("/regplayer")
    public String showPlayerForm(Player player) {
        return "regplayer";
    }

    @PostMapping("/regplayer")
    public String addPlayer(@Valid Player player, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Something went wrong while updating player {}", player);
            return "regplayer";
        }
        playerService.addPlayer(player);
        log.info("Adding playing {}", player);
        return "redirect:/players";
    }

    @GetMapping("/player/{id}/editplayer")
    public String editPlayer(Model model, @PathVariable long id) {
        model.addAttribute("editPlayer", playerService.getPlayerById(id));
        return "editplayer";
    }

    @PostMapping("/player/{id}")
    public String updateTeam(@ModelAttribute("player") @Valid Player player,
                             @PathVariable("id") long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Something went wrong while updating player {}", player);
            return "editplayer";
        }
        playerService.updatePlayer(id, player);
        log.info("Updating player{}", player);
        return "redirect:/players";
    }
}
