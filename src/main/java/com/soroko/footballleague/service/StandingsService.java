package com.soroko.footballleague.service;

import com.soroko.footballleague.repository.StandingsRepository;
import org.springframework.stereotype.Service;

@Service
public class StandingsService {
    private StandingsRepository standingsRepository;

    public StandingsService(StandingsRepository standingsRepository) {
        this.standingsRepository = standingsRepository;
    }
}
