package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.Standings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandingsRepository extends JpaRepository<Standings, Integer> {
}
