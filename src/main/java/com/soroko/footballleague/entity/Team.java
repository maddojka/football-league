package com.soroko.footballleague.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToOne
    private TeamStatistics teamStatistics;

    @OneToMany
    @JoinColumn(name = "player_id", nullable = false)
    Set<Player> players = new HashSet<>();
}
