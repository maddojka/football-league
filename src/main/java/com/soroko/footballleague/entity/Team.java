package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Name of the team is required")
    @NotBlank(message = "Name of the team is required")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotNull
    @OneToOne
    @JoinColumn(name = "team_statistics", nullable = false)
    private TeamStatistics teamStatistics;

    @NotNull
    @OneToMany
    @JoinColumn(name = "player_id", nullable = false)
    Set<Player> players = new HashSet<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "standings_id", nullable = false)
    private Standings standings;
}
