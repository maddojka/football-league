package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.repository.PlayerRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    void getPlayerById() {
        Player player = new Player(1, "Ivan", "Ivanov", Player.Position.DEFENDER);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));
        Player found = underTest.getPlayerById(1);
        assertThat(found).isEqualTo(player);
    }

    @Test
    void addPlayer() {
        Player player = new Player(1, "Ivan", "Ivanov", Player.Position.DEFENDER);
        when(playerRepository.save(any(Player.class))).thenReturn(player);
        Player savedPlayer = underTest.addPlayer(player);
        assertThat(savedPlayer).isNotNull();
    }

    @Test
    void updatePlayer() {
        Player player = new Player(1, "Ivan", "Ivanov", Player.Position.DEFENDER);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));
        when(playerRepository.save(any(Player.class))).thenReturn(player);
        Player updatedPlayer = underTest.updatePlayer(1L, player);
        assertThat(updatedPlayer).isNotNull();
    }
}