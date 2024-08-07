package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Match;
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
import java.util.Optional;

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
    void getTeamById() {
        Team team = new Team(1, LocalDateTime.now(), "Zenit",
                "Saint-Petersburg", "Zenit-Arena", new Match(), false);
        when(teamRepository.findById(1L)).thenReturn(Optional.of(team));
        Team found = underTest.getTeamById(1);
        assertThat(found).isEqualTo(team);
    }

    @Test
    void addTeam() {
        Team team = new Team(1, LocalDateTime.now(), "Zenit",
                "Saint-Petersburg", "Zenit-Arena", new Match(), false);
        when(teamRepository.save(any(Team.class))).thenReturn(team);
        Team savedTeam = underTest.addTeam(team);
        assertThat(savedTeam).isNotNull();
    }

    @Test
    void updateTeam() {
        Team team = new Team(1, LocalDateTime.now(), "Zenit",
                "Saint-Petersburg", "Zenit-Arena", new Match(), false);
        when(teamRepository.findById(1L)).thenReturn(Optional.of(team));
        when(teamRepository.save(any(Team.class))).thenReturn(team);
        Team updatedTeam = underTest.updateTeam(1L, team);
        assertThat(updatedTeam).isNotNull();
    }
}