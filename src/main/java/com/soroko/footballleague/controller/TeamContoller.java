package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.service.TeamService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/team/{id}")
    public String getTeamById(@PathVariable long id, Model model) {
        Team team = teamService.getTeamById(id);
        model.addAttribute("team_info", team);
        return "team";
    }

    @GetMapping("/regteam")
    public String showTeamForm(Team team) {
        return "regteam";
    }

    @PostMapping("/regteam")
    public String addTeam(@Valid Team team, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Something went wrong while updating team {}", team);
            return "regteam";
        }
        teamService.addTeam(team);
        log.info("Adding team {}", team);
        return "redirect:/teams";
    }
//    /form?id=

    @GetMapping("/editteam/{id}")
    public String editTeam(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("team", teamService.getTeamById(id));
        return "/teams";
    }

    @PatchMapping("editteam/{id}")
    public String updateTeam(@ModelAttribute("team") @Valid Team team,
                             @PathVariable("id") long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Something went wrong while updating team {}", team);
            return "regteam";
        }
        teamService.updateTeam(id, team);
        log.info("Updating team{}", team);
        return "redirect:/teams";
    }

}
