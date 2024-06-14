package com.soroko.footballleague.service;

import org.springframework.stereotype.Service;

@Service
public class TeamRegistrationSetvice {
    private TeamService teamService;

    public TeamRegistrationSetvice(TeamService teamService) {
        this.teamService = teamService;
    }
}
