package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Standings;
import com.soroko.footballleague.service.StandingsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/standings")
public class StandingsController {
    StandingsService standingsService;

    public StandingsController(StandingsService standingsService) {
        this.standingsService = standingsService;
    }

    @GetMapping
    public List<Standings> getAllStandings() {
        return null;
    }
}
