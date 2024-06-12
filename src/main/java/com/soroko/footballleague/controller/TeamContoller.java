package com.soroko.footballleague.controller;

import com.soroko.footballleague.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamContoller {
    private TeamService teamService;

    public TeamContoller(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return "teams";
    }
}
