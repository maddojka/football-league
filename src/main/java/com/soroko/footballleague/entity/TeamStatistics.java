package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TEAM_STATISTICS")
public class TeamStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position", length = 2)
    private int position;

    @Column(name = "matches_played")
    private int matchesPlayed;

    @Column(name = "wins")
    private int wins;

    @Column(name = "defeats")
    private int defeats;

    @Column(name = "losses")
    private int losses;

    @Column(name = "goals_for")
    private int goalsFor;

    @Column(name = "goals_against")
    private int goalsAgainst;

    @Column(name = "goals_difference")
    private int goalsDifference;

    @Column(name = "points")
    private int points;

    @OneToOne
    public Team team;


}
