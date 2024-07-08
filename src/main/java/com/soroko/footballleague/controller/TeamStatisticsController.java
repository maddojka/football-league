package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.TeamRegistrationSetvice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/teamstat")
public class TeamStatisticsController {
    TeamRegistrationSetvice teamRegistrationSetvice;

    public TeamStatisticsController(TeamRegistrationSetvice teamRegistrationSetvice) {
        this.teamRegistrationSetvice = teamRegistrationSetvice;
    }

  /*  @GetMapping("/teamstat")
    public String teamstat(Model model) {
        return null;
    }*/

}
