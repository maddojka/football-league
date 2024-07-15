package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.TeamPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRegistrationRepository extends CrudRepository<TeamPayment, Integer> {
}
