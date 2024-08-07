package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.NONE)
class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void testSaveTeam() {
        Team team = new Team(1, LocalDateTime.now(), "Zenit",
                "Saint-Petersburg", "Zenit-Arean", new Match(), false);
        teamRepository.save(team);
        Assertions.assertThat(team.getId()).isGreaterThan(0);
    }

    @Test
    @Disabled
    public void testGetTeamTest() {
        Team team01 = new Team(1L, LocalDateTime.now(), "Zenit",
                "Saint-Petersburg", "Zenit-Arean", new Match(), false);
        teamRepository.save(team01);
        Team team = teamRepository.findById(1L).get();
        Assertions.assertThat(team.getId()).isEqualTo(1L);
    }

}