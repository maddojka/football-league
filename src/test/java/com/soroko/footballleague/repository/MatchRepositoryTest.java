package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;


@DataJpaTest
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
    @Disabled
    public void testGetMatchTest() {
        Match match = matchRepository.findById(1).get();
        Assertions.assertThat(match.getId()).isEqualTo(1);
    }

}