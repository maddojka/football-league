package com.soroko.footballleague.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "STANDINGS")
public class Standings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @OneToMany
    @JoinColumn(name = "team_id", nullable = false)
    Set<Team> teams = new HashSet<>();
}
