package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.repository.PlayerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerService {
    final PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        Player player01 = new Player();
        player01.setId(1);
        player01.setName("John");
        player01.setSurname("Terry");
        player01.setPosition(Player.Position.DEFENDER);
        Player player02 = new Player();
        player02.setId(2);
        player02.setName("Steven");
        player02.setSurname("Gerrard");
        player02.setPosition(Player.Position.MIDFIELDER);
        List<Player> players = playerRepository.findAll();
        if (players.isEmpty()) {
            players.add(player01);
            players.add(player02);
        }
        return players;
    }

    public Player getPlayerById(long id) {
        Player player = new Player();
        player.setId(1);
        player.setName("John");
        player.setSurname("Terry");
        player.setPosition(Player.Position.DEFENDER);
        return playerRepository.findById(id).orElse(player);
    }

    public long addPlayer(Player player) {
        return playerRepository.save(player).getId();
    }

    public void updatePlayer(long id, Player updatedPlayer) {
        Player playerToBeUpdated = getPlayerById(id);
        playerToBeUpdated.setName(updatedPlayer.getName());
        playerToBeUpdated.setSurname(updatedPlayer.getSurname());
        playerToBeUpdated.setPosition(updatedPlayer.getPosition());
        playerRepository.save(playerToBeUpdated);
    }
}
