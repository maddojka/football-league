package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.entity.TeamPayment;
import com.soroko.footballleague.repository.TeamRegistrationRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamRegistrationSetvice {
    final TeamService teamService;
    private final TeamRegistrationRepository teamRegistrationRepository;

    public TeamPayment getTeamById(int id) {
        TeamPayment teamPayment = new TeamPayment();
        teamPayment.setId(1);
        teamPayment.setPaymentName("Liverpool registration");
        teamPayment.setCcCVV("123");
        teamPayment.setCcExpiration("03/30");
        teamPayment.setCcNumber("1234 5678 8768 2143");
        return teamRegistrationRepository.findById(id).orElse(teamPayment);
    }
}
