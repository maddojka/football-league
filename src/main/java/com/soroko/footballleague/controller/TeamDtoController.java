package com.soroko.footballleague.controller;

import com.soroko.footballleague.dto.PlayerDto;
import com.soroko.footballleague.dto.TeamDto;
import com.soroko.footballleague.entity.Player;
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
public class TeamDtoController {
    final TeamService teamService;

    @GetMapping("teamstats/{id}")
    public TeamDto getPlayerDTOById(@RequestParam long id) {
        Team team = teamService.getTeamById(id);
        TeamDto teamDto = new TeamDto();
        teamDto.setName(team.getName());
        teamDto.setCity(team.getCity());
        teamDto.setStadium(team.getStadium());
        return teamDto;
    }
}
