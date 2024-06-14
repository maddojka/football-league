package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
