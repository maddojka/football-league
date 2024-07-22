package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.service.MatchService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@Slf4j
@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchController {
    final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/matches")
    public String getAllMatches(Model model) {
        model.addAttribute("matches", matchService.getAllMatches());
        return "matches";
    }

    @GetMapping("match/{id}")
    public String getMatchById(@PathVariable int id, Model model) {
        Match match = matchService.getMatchById(id);
        model.addAttribute("match_info", match);
        return "match";
    }

    @PostMapping()
    public String addMatch(@ModelAttribute("result") @Valid Match match, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "/result";
        matchService.addMatch(match);
        return "redirect:/matches" + matchService.addMatch(match);
    }
}
