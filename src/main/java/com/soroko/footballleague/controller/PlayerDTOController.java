package com.soroko.footballleague.controller;

import com.soroko.footballleague.dto.PlayerDTO;
import com.soroko.footballleague.entity.Player;
import com.soroko.footballleague.service.PlayerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuriy.soroko
 */
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerDTOController {
    final PlayerService playerService;

    @GetMapping("playerstats/{id}")
    public PlayerDTO getPlayerDTOById(@RequestParam long id) {
        Player player = playerService.getPlayerById(id);
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName(player.getName());
        playerDTO.setSurname(player.getSurname());
        playerDTO.setPosition(player.getPosition().toString());
        return playerDTO;
    }
}
