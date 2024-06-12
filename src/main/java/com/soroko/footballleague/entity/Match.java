package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Data
@Entity
@Table(name = "MATCH")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "match_date", nullable = false)
    private LocalDateTime matchDate;

    @Column(name = "result", nullable = false)
    private String result;

  //  @OneToMany
  //  Set<Team> teams = new HashSet<>();
}
