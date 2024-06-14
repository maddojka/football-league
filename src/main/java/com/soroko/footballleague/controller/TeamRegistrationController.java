package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.TeamRegistrationSetvice;
import org.springframework.web.bind.annotation.RestController;

@RestController("/teamreg")
public class TeamRegistrationController {
    TeamRegistrationSetvice teamRegistrationSetvice;

    public TeamRegistrationController(TeamRegistrationSetvice teamRegistrationSetvice) {
        this.teamRegistrationSetvice = teamRegistrationSetvice;
    }
}
