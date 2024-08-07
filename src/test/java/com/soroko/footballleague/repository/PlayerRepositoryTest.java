package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testSavePlayer() {
        Player player = new Player(1,"Ivan", "Ivanov", Player.Position.DEFENDER);
        playerRepository.save(player);
        Assertions.assertThat(player.getId()).isGreaterThan(0);
    }
}