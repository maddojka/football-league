package com.soroko.footballleague.service;


import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Iterable<Team> getAllTeams() {
        Team team01 = new Team();
        team01.setId(1);
        team01.setName("Liverpool");
        Team team02 = new Team();
        team02.setId(2);
        team02.setName("Everton");
        List<Team> teams = (List<Team>) teamRepository.findAll();
        if (teams.isEmpty()) {
            teams.add(team01);
            teams.add(team02);
        }
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
}
