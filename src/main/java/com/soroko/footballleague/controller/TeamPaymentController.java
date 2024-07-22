package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.TeamPayment;
import com.soroko.footballleague.service.TeamRegistrationSetvice;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/payments")
@SessionAttributes("teamPayment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamPaymentController {
    final TeamRegistrationSetvice teamRegistrationSetvice;

    public TeamPaymentController(TeamRegistrationSetvice teamRegistrationSetvice) {
        this.teamRegistrationSetvice = teamRegistrationSetvice;
    }

    @GetMapping("/current")
    public String paymentForm() {
        return "paymentForm";
    }

    @PostMapping()
    public String processPayment(@Valid TeamPayment teamPayment, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "paymentForm";
        }
        log.info("Order submitted: {}", teamPayment);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping("/approved")
    public String showTeamRegistrations(Model model) {
        return null;
    }
}
