package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer> {

}
