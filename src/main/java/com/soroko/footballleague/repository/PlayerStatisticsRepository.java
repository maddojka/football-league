package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.PlayerStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatisticsRepository extends CrudRepository<PlayerStatistics, Integer> {
}
