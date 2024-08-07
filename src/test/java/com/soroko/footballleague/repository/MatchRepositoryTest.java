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
class MatchRepositoryTest {

    @Autowired
    private MatchRepository matchRepository;


    @Test
    public void testSaveMatch() {
        Match match = new Match(1, LocalDateTime.now(), "1-1", new ArrayList<Team>());
        matchRepository.save(match);
        Assertions.assertThat(match.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindAllMatches() {
        Match match01 = new Match(1, LocalDateTime.now(), "1-1", new ArrayList<Team>());
        Match match02 = new Match(2, LocalDateTime.now(), "2-1", new ArrayList<Team>());
        matchRepository.save(match01);
        matchRepository.save(match02);
        List<Match> matches = matchRepository.findAll();
        Assertions.assertThat(matches).isNotNull();
        Assertions.assertThat(matches).isNotEmpty();
    }

    @Test
    @Disabled
    public void testGetMatchTest() {
        Match match01 = new Match(1, LocalDateTime.now(), "1-1", new ArrayList<Team>());
        matchRepository.save(match01);
        Match match = matchRepository.findById(1).get();
        Assertions.assertThat(match.getId()).isEqualTo(1);
    }

}