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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchController {
    final MatchService matchService;

    /**
     * Show all available matches
     */
    @GetMapping("/matches")
    public String getAllMatches(Model model) {
        model.addAttribute("matches", matchService.getAllMatches());
        return "matches";
    }

    /**
     * Return match by endpoint id
     */
    @GetMapping("match/{id}")
    public String getMatchById(@PathVariable int id, Model model) {
        Match match = matchService.getMatchById(id);
        model.addAttribute("match_info", match);
        return "match";
    }

    /**
     * Get register match form
     */
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

    /**
     * Adding new match to database
     */
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

    /**
     * Get edit form of the match by id
     */
    @GetMapping("match/{id}/editresult")
    public String editMatch(Model model, @PathVariable int id) {
        model.addAttribute("editResult", matchService.getMatchById(id));
        return "editresult";
    }

    /**
     * Edit data of existing match by id
     */
    @PostMapping("match/{id}")
    public String updateMatch(@ModelAttribute("match") @Valid Match match,
                              @PathVariable int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            log.error("Something went wrong while updating match result {}", match);
            return "editresult";
        }
        matchService.updateMatch(id, match);
        log.info("Updating match {}", match);
        return "redirect:/matches";
    }
}
