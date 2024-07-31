package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.Team;
import com.soroko.footballleague.entity.TeamPayment;
import com.soroko.footballleague.service.TeamRegistrationSetvice;
import com.soroko.footballleague.service.TeamService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequiredArgsConstructor
/*@RequestMapping("/payments")*/
@SessionAttributes("teamPayment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamPaymentController {
    final TeamRegistrationSetvice teamRegistrationSetvice;
    final TeamService teamService;

    /*@GetMapping("team/{id}/payment")
    public String paymentForm() {
        return "payment";
    }*/

    @GetMapping("team/payment")
    public String getTeamById(@RequestParam("id") int id, Model model) {
        TeamPayment teamPayment = teamRegistrationSetvice.getTeamById(id);
        model.addAttribute("payment_info", teamPayment);
        return "payment";
    }

    @PostMapping("payment")
    public String processPayment(@Valid TeamPayment teamPayment, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "payment";
        }
        log.info("Order submitted: {}", teamPayment);
        sessionStatus.setComplete();
        return "redirect:/team/" + teamPayment.getId();
    }

    /*@GetMapping("/approved")
    public String showTeamRegistrations(Model model) {
        return null;
    }*/
}
