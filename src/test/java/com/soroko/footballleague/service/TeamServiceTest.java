package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.News;
import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.repository.TeamRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;
    @InjectMocks
    private TeamService underTest;

    @Test
    void getAllTeams() {
        List<Team> teams = new ArrayList<>();
        when(teamRepository.findAll()).thenReturn(teams);
        List<Team> created = underTest.getAllTeams();
        assertThat(created).isEqualTo(teams);
    }

    @Test
    @Disabled
    void getTeamById() {
    }

    @Test
    void addTeam() {
        Team team = new Team(1, LocalDateTime.now(), "Zenit",
                "Saint-Petersburg", "Zenit-Arean", new Match(), false);
        when(teamRepository.save(any(Team.class))).thenReturn(team);
        Team savedTeam = underTest.addTeam(team);
        assertThat(savedTeam).isNotNull();
    }

    @Test
    @Disabled
    void updateTeam() {
    }
}