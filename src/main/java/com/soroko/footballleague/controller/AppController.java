package com.soroko.footballleague.controller;


import com.soroko.footballleague.entity.Request;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Value("${stripe.api.publicKey}")
    private String publicKey;
    @GetMapping("/deposit")
    public String home(Model model){
        model.addAttribute("request", new Request());
        return "deposit";
    }

    /**
     * Formation of payment information
     */
    @PostMapping("/deposit")
    public String showCard(@ModelAttribute @Valid Request request,
                               BindingResult bindingResult,
                               Model model){
        if (bindingResult.hasErrors()){
            return "deposit";
        }
        model.addAttribute("publicKey", publicKey);
        model.addAttribute("amount", request.getAmount());
        model.addAttribute("email", request.getEmail());
        model.addAttribute("teamName", request.getTeamName());
        return "checkout";
    }
}
