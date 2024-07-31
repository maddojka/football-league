package com.soroko.footballleague.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "player")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull(message = "Name of the player is required")
    @NotBlank(message = "Name of the player is required")
    @Size(min = 2, max = 30)
    @Column(name = "name", nullable = false, length = 50)
    String name;

    @NotNull(message = "Surname of the player is required")
    @NotBlank(message = "Surname of the player is required")
    @Size(min = 2, max = 30)
    @Column(name = "surname", nullable = false, length = 50)
    String surname;

    /*@NotNull(message = "Position of the player is required")
    @NotBlank(message = "Position of the player is required")
    @Size(min = 2, max = 30)
    @Column(name = "position", nullable = false, length = 50)
    private String position;*/

    @NotNull
    Position position;

   /* @NotNull
    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    Team team;*/

    public enum Position {
        GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD
    }
}
