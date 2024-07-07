package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/match")
public class MatchController {
    MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/info")
    public String getMatchInfo() {
        return null;
    }

    @PostMapping("/result")
    public String addMatch(@Valid Match match, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {}
        return null;
    }
}
