package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.Standings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandingsRepository extends CrudRepository<Standings, Integer> {
}
