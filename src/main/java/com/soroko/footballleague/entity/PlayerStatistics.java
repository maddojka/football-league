package com.soroko.footballleague.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PLAYER_STATISTICS")
public class PlayerStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "matches_played")
    private int matchesPlayed;

    @Column(name = "goals_scored")
    private int goalsScored;

    @Column(name = "yellow_cards")
    private int yellowCards;

    @Column(name = "red_cards")
    private int redCards;

    @Column(name = "submissions")
    private int submissions;

    @OneToOne
    private Player player;
}
