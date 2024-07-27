package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.StandingsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StandingsController {
    final StandingsService standingsService;

    @GetMapping("/standings")
    public String getStandings() {
        return "standings";
    }
}
