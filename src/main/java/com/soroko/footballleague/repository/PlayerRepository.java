package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
