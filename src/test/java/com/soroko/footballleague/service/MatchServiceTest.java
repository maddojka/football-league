package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.repository.MatchRepository;
import com.soroko.footballleague.repository.PlayerRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MatchServiceTest {

    @Mock
    private MatchRepository matchRepository;
    @InjectMocks
    private MatchService underTest;

    @Test
    void getAllMatches() {
        List<Match> matches = new ArrayList<>();
        when(matchRepository.findAll()).thenReturn(matches);
        List<Match> created = underTest.getAllMatches();
        assertThat(created).isEqualTo(matches);
    }

    @Test
    @Disabled
    void getMatchById() {
    }

    @Test
    void addMatch() {
        Match match = new Match(1, LocalDateTime.now(), "1-1", new ArrayList<Team>());
        when(matchRepository.save(any(Match.class))).thenReturn(match);
        Match savedMatch = underTest.addMatch(match);
        assertThat(savedMatch).isNotNull();
    }

    @Test
    @Disabled
    void updateMatch() {
    }
}