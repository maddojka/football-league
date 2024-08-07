package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.repository.PlayerRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;
    @InjectMocks
    private PlayerService underTest;

    @Test
    void canGetAllPlayers() {
        List<Player> players = new ArrayList<>();
        when(playerRepository.findAll()).thenReturn(players);
        List<Player> created = underTest.getAllPlayers();
        assertThat(created).isEqualTo(players);
    }

    @Test
    @Disabled
    void getPlayerById() {
    }

    @Test
    void addPlayer() {
        Player player = new Player(1, "Ivan", "Ivanov", Player.Position.DEFENDER);
        when(playerRepository.save(any(Player.class))).thenReturn(player);
        Player savedPlayer = underTest.addPlayer(player);
        assertThat(savedPlayer).isNotNull();
    }

    @Test
    @Disabled
    void updatePlayer() {
    }
}