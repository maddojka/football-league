package com.soroko.footballleague.service;

import com.soroko.footballleague.dto.TeamDTO;
import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.repository.MatchRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchService {
    final MatchRepository matchRepository;
    final List<TeamDTO> teamDTOS;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(int id) {
        return matchRepository.findById(id).orElseThrow(
                () -> new MatchException(("No match found with id: " + id), new IllegalArgumentException()));
    }

    public Match addMatch(Match match) {
        String result = match.getResult();
        return matchRepository.save(match);
    }

    public Match updateMatch(int id, Match updatedMatch) {
        Match matchToBeUpdated = getMatchById(id);
        matchToBeUpdated.setMatchDate(updatedMatch.getMatchDate());
        matchToBeUpdated.setResult(updatedMatch.getResult());
        matchToBeUpdated.setTeams(updatedMatch.getTeams());
        return matchRepository.save(matchToBeUpdated);
    }
}
