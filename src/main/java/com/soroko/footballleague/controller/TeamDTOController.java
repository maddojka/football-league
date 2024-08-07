package com.soroko.footballleague.controller;

import com.soroko.footballleague.dto.TeamDTO;
import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.service.TeamService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuriy.soroko
 */
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamDTOController {
    final TeamService teamService;

    @GetMapping("teamstats/{id}")
    public TeamDTO getPlayerDTOById(@RequestParam long id) {
        Team team = teamService.getTeamById(id);
        TeamDTO teamDto = new TeamDTO();
        teamDto.setName(team.getName());
        teamDto.setCity(team.getCity());
        teamDto.setStadium(team.getStadium());
        return teamDto;
    }
}
