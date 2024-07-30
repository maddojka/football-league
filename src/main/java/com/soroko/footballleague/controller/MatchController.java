package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.service.MatchService;
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
public class MatchController {
    final MatchService matchService;

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

    @GetMapping("/result")
    public String showMatches(Match match) {
        return "result";
    }

    @PostMapping("/result")
    public String addMatch(@Valid Match match, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "result";
        matchService.addMatch(match);
        log.info("Adding match {}", match);
        return "redirect:/matches";
    }

    @GetMapping("/editresult/{id}")
    public String editMatch(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute("match", matchService.getMatchById(id));
        return "/matches";
    }

    @PatchMapping("/editresult/{id}")
    public String updateMatch(@ModelAttribute("match") @Valid Match match,
                              @PathVariable("id") int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "editresult";
        matchService.updateMatch(id, match);
        log.info("Updating match {}", match);
        return "redirect:/matches";
    }
}
