package com.soroko.footballleague.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PLAYER")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "position", nullable = false)
    private String position;

    @OneToOne
    private PlayerStatistics playerStatistics;
}
