package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.service.TeamService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequestMapping("/teams")
public class TeamContoller {
    private TeamService teamService;

    public TeamContoller(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public String getAllTeams(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return "teams";
    }

    @GetMapping("/form")
    public String getTeamAddForm(Team team) {
        return "team/team-add-form";
    }

    @PostMapping
    public String addTeam(@Valid Team team,
                            BindingResult bindingResult,
                            Model model) {
        return null;
    }
}
