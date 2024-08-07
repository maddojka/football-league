package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.repository.PlayerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
        return playerRepository.findAll();
    }

    public Player getPlayerById(long id) {
        return playerRepository.findById(id).orElseThrow(
                () -> new MatchException(("No player found with id: " + id), new IllegalArgumentException()));
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public void updatePlayer(long id, Player updatedPlayer) {
        Player playerToBeUpdated = getPlayerById(id);
        playerToBeUpdated.setName(updatedPlayer.getName());
        playerToBeUpdated.setSurname(updatedPlayer.getSurname());
        playerToBeUpdated.setPosition(updatedPlayer.getPosition());
        playerRepository.save(playerToBeUpdated);
    }
}
