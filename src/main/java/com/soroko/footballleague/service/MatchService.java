package com.soroko.footballleague.service;

import com.soroko.footballleague.dto.TeamDto;
import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.repository.MatchRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchService {
    final MatchRepository matchRepository;
    final List<TeamDto> teamDTOs;

    public List<Match> getAllMatches() {
        List<Match> matches = matchRepository.findAll();
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
        String result = match.getResult();
        return matchRepository.save(match).getId();
    }

    public void updateMatch(int id, Match updatedMatch) {
        Match matchToBeUpdated = getMatchById(id);
        matchToBeUpdated.setMatchDate(updatedMatch.getMatchDate());
        matchToBeUpdated.setResult(updatedMatch.getResult());
        matchToBeUpdated.setTeams(updatedMatch.getTeams());
        matchRepository.save(matchToBeUpdated);
    }
}
