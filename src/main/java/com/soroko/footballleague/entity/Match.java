package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "match")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    long id;

    @NotNull(message = "Date of the match is required")
    @DateTimeFormat
    @Column(name = "match_date", nullable = false)
    LocalDateTime matchDate;

    @NotNull(message = "Result is required")
    @NotBlank(message = "Result is required")
    @Column(name = "result", nullable = false)
    String result;

    @NotNull
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    List<Team> teams = new ArrayList<>();


}

