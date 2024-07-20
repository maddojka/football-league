package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.StandingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/standings")
public class StandingsController {
    StandingsService standingsService;

    public StandingsController(StandingsService standingsService) {
        this.standingsService = standingsService;
    }

  /*  @GetMapping
    public List<Standings> getAllStandings() {
        return null;
    }*/
}
