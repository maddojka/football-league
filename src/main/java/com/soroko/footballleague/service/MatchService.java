package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.repository.MatchRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchService {
    final MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        List<Team> teams = new ArrayList<>();
        Team team01 = new Team();
        team01.setId(1);
        team01.setName("Liverpool");
        Team team02 = new Team();
        team02.setId(2);
        team02.setName("Everton");
        teams.add(team01);
        teams.add(team02);
        Match match01 = new Match();
        match01.setId(1);
        match01.setTeams(teams);
        match01.setMatchDate(LocalDateTime.now());
        match01.setResult("1-0");
        Match match02 = new Match();
        match02.setId(2);
        match02.setTeams(teams);
        match02.setMatchDate(LocalDateTime.now());
        match02.setResult("0-0");
        List<Match> matches = matchRepository.findAll();
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

    public void updateMatch(int id, Match updatedMatch) {
        Match matchToBeUpdated = getMatchById(id);
        matchToBeUpdated.setMatchDate(updatedMatch.getMatchDate());
        matchToBeUpdated.setResult(updatedMatch.getResult());
    }
}
