package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.TeamStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamStatisticsRepository extends CrudRepository<TeamStatistics, Integer> {
}
