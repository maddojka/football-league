package com.soroko.footballleague.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
