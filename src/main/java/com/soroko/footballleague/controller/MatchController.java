package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController("/matches")
public class MatchController {
    MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
}
