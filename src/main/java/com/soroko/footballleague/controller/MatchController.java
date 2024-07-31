package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.Team;
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
import org.springframework.web.servlet.ModelAndView;

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

   /* @GetMapping("/result")
    public String showMatches(Match match) {
        match.getTeams().add(new Team());
        match.getTeams().add(new Team());
        return "result";
    }*/

    @GetMapping("/result")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Match match = new Match();
        match.getTeams().add(new Team());
        match.getTeams().add(new Team());
        modelAndView.addObject("match", match);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    /*@GetMapping("/result")
    public String showResultForm(Model model) {
        Match match = new Match();
        match.getTeams().add(new Team());
        match.getTeams().add(new Team());
        model.addAttribute("result", match);
        return "result";
    }*/

    @PostMapping("/result")
    public String addMatch(@Valid Match match, BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            log.error("Something went wrong while updating match result {}", match);
            return "result";
        }

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
        if (bindingResult.hasErrors())  {
            log.error("Something went wrong while updating match result {}", match);
            return "result";
        }
        matchService.updateMatch(id, match);
        log.info("Updating match {}", match);
        return "redirect:/matches";
    }


}
