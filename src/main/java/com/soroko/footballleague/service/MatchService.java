package com.soroko.footballleague.service;

import com.soroko.footballleague.repository.MatchRepository;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    private MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }
}
