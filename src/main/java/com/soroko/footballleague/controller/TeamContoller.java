package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.service.TeamRegistrationSetvice;
import com.soroko.footballleague.service.TeamService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
//@RequestMapping("/teams")
public class TeamContoller {
    final TeamService teamService;

    public TeamContoller(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return "teams";
    }

    @GetMapping("team/{id}")
    public String getTeamById(@PathVariable long id, Model model) {
        Team team = teamService.getTeamById(id);
        model.addAttribute("team_info", team);
        return "team";
    }

    @PostMapping("/regteam")
    public String addTeam(@Valid Team team, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "/regteam";
        return "redirect:/regteam/form?id=" + teamService.addTeam(team);
    }
}
