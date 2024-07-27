package com.soroko.footballleague.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "standings")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Standings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull(message = "Title is required")
    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 30)
    @Column(name = "title", nullable = false)
    String title;

    @NotNull
    @OneToMany
    @JoinColumn(name = "team_stand_id", nullable = false)
    Set<Team> teams = new HashSet<>();
}
