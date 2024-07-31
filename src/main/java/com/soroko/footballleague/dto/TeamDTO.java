package com.soroko.footballleague.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author yuriy.soroko
 */
@Getter
@Setter
@RequiredArgsConstructor
@Component
public class TeamDTO {

    String position;

    String name;

    @PositiveOrZero
    int matchesPlayed;
    @PositiveOrZero
    int wins;
    @PositiveOrZero
    int defeats;
    @PositiveOrZero
    int draws;
    @PositiveOrZero
    int goalsFor;
    @PositiveOrZero
    int goalsAgainst;

    int goalsDifference = goalsFor - goalsAgainst;
    @PositiveOrZero
    int points;

}
