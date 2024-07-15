package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "The date of the registration is required")
    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;

    @NotNull(message = "Name of the team is required")
    @NotBlank(message = "Name of the team is required")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotNull(message = "City is required")
    @NotBlank(message = "City is required")
    @Size(min = 2, max = 50)
    @Column(name = "city", nullable = false)
    private String City;

    @NotNull(message = "Stadium is required")
    @NotBlank(message = "Stadium is required")
    @Size(min = 2, max = 50)
    @Column(name = "stadium", nullable = false)
    private String stadium;

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

    @Column(name = "deposit_approved")
    private boolean depositApproved = false;

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
