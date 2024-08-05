package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.StandingsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StandingsController {
    final StandingsService standingsService;

    @GetMapping("/standings")
    public String getStandings() {
        return "standings";
    }

    @PostMapping("/standings")
    public String addStanding(@RequestParam String name, @RequestParam int year) {
        return "";
    }
}
