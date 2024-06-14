package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity
@Table(name = "TEAM_STATISTICS")
public class TeamStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Position is required")
    @NotBlank(message = "Position is required")
    @Column(name = "position", nullable = false)
    private String position;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "matches_played")
    private int matchesPlayed;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "wins")
    private int wins;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "defeats")
    private int defeats;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "losses")
    private int losses;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "goals_for")
    private int goalsFor;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "goals_against")
    private int goalsAgainst;


    @Column(name = "goals_difference")
    private int goalsDifference;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "points")
    private int points;

    @NotNull
    @OneToOne
    @JoinColumn(name = "team_id", nullable = false)
    public Team team;

}
