package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.repository.PlayerRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Iterable<Player> getAllPlayers() {
        Player player01 = new Player();
        player01.setId(1);
        player01.setName("John");
        player01.setSurname("Terry");
        player01.setPosition("defender");
        Player player02 = new Player();
        player02.setId(2);
        player02.setName("Steven");
        player02.setSurname("Gerrard");
        player02.setPosition("midfielder");
        List<Player> players = (List<Player>) playerRepository.findAll();
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
        player.setPosition("defender");
        return playerRepository.findById(id).orElse(player);
    }

    public long addPlayer(Player player) {
        return playerRepository.save(player).getId();
    }
}
