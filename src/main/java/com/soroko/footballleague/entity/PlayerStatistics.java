package com.soroko.footballleague.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity
@Table(name = "player_statistics")
public class PlayerStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "matches_played")
    private int matchesPlayed;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer=3, fraction=0, message="Invalid amount of goals")
    @Column(name = "goals_scored")
    private int goalsScored;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer=2, fraction=0, message="Invalid amount of yellow cards")
    @Column(name = "yellow_cards")
    private int yellowCards;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer=2, fraction=0, message="Invalid amount of red cards")
    @Column(name = "red_cards")
    private int redCards;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer=2, fraction=0, message="Invalid amount of submissions")
    @Column(name = "submissions")
    private int submissions;

    @NotNull
    @OneToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;
}
