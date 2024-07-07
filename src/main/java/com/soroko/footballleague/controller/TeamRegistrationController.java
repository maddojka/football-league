package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.TeamRegistration;
import com.soroko.footballleague.service.TeamRegistrationSetvice;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/teamreg")
public class TeamRegistrationController {
    TeamRegistrationSetvice teamRegistrationSetvice;

    public TeamRegistrationController(TeamRegistrationSetvice teamRegistrationSetvice) {
        this.teamRegistrationSetvice = teamRegistrationSetvice;
    }

    @PostMapping("/payment")
    public String AddPayment(@RequestBody TeamRegistration teamRegistration, Model model) {
        return null;
    }

    @GetMapping("/approved")
    public String showTeamRegistrations(Model model) {
        return null;
    }
}
