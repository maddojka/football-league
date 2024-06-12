package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
