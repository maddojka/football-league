package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.NONE)
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testSavePlayer() {
        Player player = new Player(1,"Ivan", "Ivanov", Player.Position.DEFENDER);
        playerRepository.save(player);
        Assertions.assertThat(player.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindAllPlayers() {
        Player player01 = new Player(1,"Ivan", "Ivanov", Player.Position.DEFENDER);
        Player player02 = new Player(2,"Ivan", "Ivanov", Player.Position.DEFENDER);
        playerRepository.save(player01);
        playerRepository.save(player02);
        List<Player> players = playerRepository.findAll();
        Assertions.assertThat(players).isNotNull();
        Assertions.assertThat(players).isNotEmpty();
    }

    @Test
    @Disabled
    public void testGetPlayerTest() {
        Player player01 = new Player(1L,"Ivan", "Ivanov", Player.Position.DEFENDER);
        playerRepository.save(player01);
        Player player = playerRepository.findById(1L).get();
        Assertions.assertThat(player.getId()).isEqualTo(1L);
    }
}