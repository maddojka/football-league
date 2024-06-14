package com.soroko.footballleague.service;

import com.soroko.footballleague.repository.TeamStatisticsRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamStatisticsService {

    private TeamStatisticsRepository teamStatisticsRepository;

    public TeamStatisticsService(TeamStatisticsRepository teamStatisticsRepository) {
        this.teamStatisticsRepository = teamStatisticsRepository;
    }
}
