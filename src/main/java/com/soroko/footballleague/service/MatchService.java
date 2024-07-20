package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchService {
    private MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Iterable<Match> getAllMatches() {
        Match match01 = new Match();
        match01.setId(1);
        match01.setMatchDate(LocalDateTime.now());
        match01.setResult("1-0");
        Match match02 = new Match();
        match02.setId(2);
        match02.setMatchDate(LocalDateTime.now());
        match02.setResult("0-0");
        List<Match> matches = (List<Match>) matchRepository.findAll();
        if (matches.isEmpty()) {
            matches.add(match01);
            matches.add(match02);
        }
        return matches;
    }

    public Match getMatchById(int id) {
        Match match = new Match();
        match.setId(1);
        match.setMatchDate(LocalDateTime.now());
        match.setResult("2-1");
        return matchRepository.findById(id).orElse(match);
    }

    public long addMatch(Match match) {
        return matchRepository.save(match).getId();
    }
}
