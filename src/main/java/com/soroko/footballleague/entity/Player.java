package com.soroko.footballleague.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Name of the player is required")
    @NotBlank(message = "Name of the player is required")
    @Size(min = 2, max = 30)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull(message = "Surname of the player is required")
    @NotBlank(message = "Surname of the player is required")
    @Size(min = 2, max = 30)
    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @NotNull(message = "Position of the player is required")
    @NotBlank(message = "Position of the player is required")
    @Size(min = 2, max = 30)
    @Column(name = "position", nullable = false, length = 50)
    private String position;

    @NotNull
    @OneToOne
    @JoinColumn(name = "player_statistics", nullable = false)
    private PlayerStatistics playerStatistics;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
}
