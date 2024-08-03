package com.soroko.footballleague.service;

import com.soroko.footballleague.dto.TeamDTO;
import com.soroko.footballleague.entity.Match;
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
    final List<TeamDTO> teamDTOs;

    public List<Match> getAllMatches() {
       /* List<Team> teams = new ArrayList<>();
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
        match02.setResult("0-0");*/
        List<Match> matches = matchRepository.findAll();
      /*  if (matches.isEmpty()) {
            matches.add(match01);
            matches.add(match02);
        }*/
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
        parseResult(result, match.getTeams(), teamDTOs);

        return matchRepository.save(match).getId();
    }

    public void updateMatch(int id, Match updatedMatch) {
        Match matchToBeUpdated = getMatchById(id);
        matchToBeUpdated.setMatchDate(updatedMatch.getMatchDate());
        matchToBeUpdated.setResult(updatedMatch.getResult());
    }

    public void parseResult(String result, List<Team> teams, List<TeamDTO> teamDTOs) {
        String[] score = result.split("-");
        int firstScore = Integer.parseInt(score[0]);
        int secondScore = Integer.parseInt(score[1]);
        TeamDTO firstDto = new TeamDTO();
        TeamDTO secondDto = new TeamDTO();
        teamDTOs.add(firstDto);
        teamDTOs.add(secondDto);
        teamDTOs.get(0).setName(teams.get(0).getName());
        teamDTOs.get(1).setName(teams.get(1).getName());
        if (firstScore > secondScore) {
            teamDTOs.get(0).setWins(+1);
            teamDTOs.get(0).setMatchesPlayed(+1);
            teamDTOs.get(0).setGoalsFor(+firstScore);
            teamDTOs.get(0).setGoalsAgainst(-secondScore);
            teamDTOs.get(0).setPoints(+3);
            teamDTOs.get(1).setDefeats(-1);
            teamDTOs.get(1).setMatchesPlayed(+1);
            teamDTOs.get(1).setGoalsFor(+secondScore);
            teamDTOs.get(1).setGoalsAgainst(-firstScore);

        } else if (firstScore < secondScore) {
            teamDTOs.get(1).setWins(+1);
            teamDTOs.get(1).setMatchesPlayed(+1);
            teamDTOs.get(1).setGoalsFor(+firstScore);
            teamDTOs.get(1).setGoalsAgainst(-secondScore);
            teamDTOs.get(1).setPoints(+3);
            teamDTOs.get(0).setDefeats(-1);
            teamDTOs.get(0).setMatchesPlayed(+1);
            teamDTOs.get(0).setGoalsFor(+secondScore);
            teamDTOs.get(0).setGoalsAgainst(-firstScore);
        } else if (firstScore == secondScore) {
            teamDTOs.get(0).setDraws(+1);
            teamDTOs.get(0).setMatchesPlayed(+1);
            teamDTOs.get(0).setGoalsFor(+firstScore);
            teamDTOs.get(0).setGoalsAgainst(-secondScore);
            teamDTOs.get(0).setPoints(+1);
            teamDTOs.get(0).setDraws(+1);
            teamDTOs.get(0).setMatchesPlayed(+1);
            teamDTOs.get(0).setGoalsFor(+secondScore);
            teamDTOs.get(0).setGoalsAgainst(-firstScore);
        }


    }
}
