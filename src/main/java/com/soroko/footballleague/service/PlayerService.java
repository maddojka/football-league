package com.soroko.footballleague.service;

import com.soroko.footballleague.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
}
