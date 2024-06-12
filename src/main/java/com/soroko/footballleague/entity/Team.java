package com.soroko.footballleague.entity;


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

    @Column(name = "place", length = 2, nullable = false)
    private int place;

    @Column(name = "points", nullable = false)
    private int points;

    @OneToMany
    @JoinColumn(name = "player_id", nullable = false)
    Set<Player> players = new HashSet<>();
}
