package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.service.TeamService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.math.raw.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamContoller {
    final TeamService teamService;

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
    public String addTeam(@ModelAttribute("team") @Valid Team team, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "/regteam";
        teamService.addTeam(team);
        return "redirect:/teams"/* + teamService.addTeam(team)*/;
    }
//    /form?id=

    @GetMapping("team/{id}/edit")
    public String editTeam(Model model, @PathVariable("id") long id) {
        model.addAttribute("team", teamService.getTeamById(id));
        return "team/edit";
    }

    /*@PatchMapping("team/{id}")
    public String updateTeam(@ModelAttribute("team") @Valid Team team,
                             @PathVariable("id") long id, BindingResult bindingResult) {
        teamService.updateTeam(id, team);
        return "redirect:/teams";
    }*/
}
