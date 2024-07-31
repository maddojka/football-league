package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "team")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    long id;

    @NotNull(message = "The date of the registration is required")
    @Column(name = "registered_at", nullable = false)
    LocalDateTime registeredAt = LocalDateTime.now();

    @NotNull(message = "Name of the team is required")
    @NotBlank(message = "Name of the team is required")
    @Column(name = "name", length = 50, nullable = false)
    String name;


    @Size(min = 2, max = 50)
    @Column(name = "city")
    String city;

    @Size(min = 2, max = 50)
    @Column(name = "stadium")
    String stadium;

//    @ManyToMany(fetch = FetchType.LAZY)
    @ManyToMany/*(mappedBy = "teams", cascade = CascadeType.ALL)*/
    List<Match> matches = new ArrayList<>();

    // @NotNull
   /* @OneToMany
    @JoinColumn(name = "player_id", nullable = false)
    Set<Player> players = new HashSet<>();*/

  /*  @NotNull
    @ManyToOne
    @JoinColumn(name = "standings_id", nullable = false)
    Standings standings;*/

    @Column(name = "deposit_approved")
    boolean depositApproved = false;


}
