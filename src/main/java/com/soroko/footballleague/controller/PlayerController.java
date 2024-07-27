package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.service.PlayerService;
import com.soroko.footballleague.service.TeamService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerController {
    final PlayerService playerService;
    private final TeamService teamService;

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

    @PostMapping("/regplayer")
    public String addPlayer(@ModelAttribute("player") @Valid Player player, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "/regplayer";
        playerService.addPlayer(player);
        return "redirect:/players" + playerService.addPlayer(player);
    }
}
