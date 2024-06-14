package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.StandingsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController("/standings")
public class StandingsController {
    StandingsService standingsService;

    public StandingsController(StandingsService standingsService) {
        this.standingsService = standingsService;
    }
}
