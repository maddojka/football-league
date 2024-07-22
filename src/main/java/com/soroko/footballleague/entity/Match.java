package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "match")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull(message = "Date of the match is required")
    @Column(name = "match_date", nullable = false)
    LocalDateTime matchDate;

    @NotNull(message = "Result is required")
    @NotBlank(message = "Result is required")
    @Column(name = "result", nullable = false)
    String result;

    @NotNull
    @OneToMany
    @JoinColumn(name = "team_id", nullable = false)
    Set<Team> teams = new HashSet<>();
}
