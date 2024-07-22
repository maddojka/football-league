package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "news")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull(message = "Text of the news is required")
    @NotBlank(message = "Text of the news is required")
    @Column(name = "text", nullable = false, length = 3000)
    String text;

    @NotNull(message = "Date of the news is required")
    @Column(name = "created_at", nullable = false)
    LocalDateTime created_at;
}
