package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.TeamRegistrationSetvice;
import org.springframework.web.bind.annotation.RestController;

@RestController("/teamstats")
public class TeamStatisticsController {
    TeamRegistrationSetvice teamRegistrationSetvice;

    public TeamStatisticsController(TeamRegistrationSetvice teamRegistrationSetvice) {
        this.teamRegistrationSetvice = teamRegistrationSetvice;
    }
}
