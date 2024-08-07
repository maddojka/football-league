package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
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

}