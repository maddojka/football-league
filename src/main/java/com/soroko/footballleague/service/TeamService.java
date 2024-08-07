package com.soroko.footballleague.service;


import com.soroko.footballleague.dto.TeamDTO;
import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.repository.TeamRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamService {
    final TeamRepository teamRepository;
    TeamDTO teamDTO;

    public List<Team> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams;
    }

    public Team getTeamById(long id) {
        return teamRepository.findById(id).orElseThrow(
                () -> new MatchException(("No team found with id: " + id), new IllegalArgumentException()));
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(long id, Team updatedTeam) {
        Team teamToBeUpdated = getTeamById(id);
        teamToBeUpdated.setName(updatedTeam.getName());
        teamToBeUpdated.setCity(updatedTeam.getCity());
        teamToBeUpdated.setStadium(updatedTeam.getStadium());
        return teamRepository.save(teamToBeUpdated);
    }
}
