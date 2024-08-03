package com.soroko.footballleague.service;


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

    public List<Team> getAllTeams() {
     /*   Team team01 = new Team();
        team01.setId(1);
        team01.setName("Liverpool");
        Team team02 = new Team();
        team02.setId(2);
        team02.setName("Everton");*/
        List<Team> teams = teamRepository.findAll();
     /*   if (teams.isEmpty()) {
            teams.add(team01);
            teams.add(team02);
        }*/
        return teams;
    }

    public Team getTeamById(long id) {
        Team team01 = new Team();
        team01.setId(3);
        team01.setName("Chelsea");
        return teamRepository.findById(id).orElse(team01);
    }

    public long addTeam(Team team) {
        return teamRepository.save(team).getId();
    }

    public void updateTeam(long id, Team updatedTeam) {
        Team teamToBeUpdated = getTeamById(id);
        teamToBeUpdated.setName(updatedTeam.getName());
        teamToBeUpdated.setCity(updatedTeam.getCity());
        teamToBeUpdated.setStadium(updatedTeam.getStadium());
    }
}
