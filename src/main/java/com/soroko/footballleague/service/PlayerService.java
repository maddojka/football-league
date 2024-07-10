package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Iterable<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(long id) {
        Player player = new Player();
        player.setId(1);
        player.setName("John");
        player.setSurname("Terry");
        player.setPosition("defender");
        return playerRepository.findById(id).orElse(player);
        // return doctorRepository.findById(id)
        // .orElseThrow(()->new ClinicException("Доктор не найден"));
    }
}
