package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "team_registration")
public class TeamRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "The date of the registration is required")
    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;

    @NotNull(message = "City is required")
    @NotBlank(message = "City is required")
    @Size(min = 2, max = 50)
    @Column(name = "city", nullable = false)
    private String City;

    @NotNull(message = "Stadium is required")
    @NotBlank(message = "Stadium is required")
    @Size(min = 2, max = 50)
    @Column(name = "stadium", nullable = false)
    private String stadium;

    @NotNull(message = "Credit card number is required")
    @NotBlank(message = "Credit card number is required")
    @CreditCardNumber(message = "Not a valid credit card number")
    @Column(name = "cc_number", nullable = false)
    private String ccNumber;

    @NotNull(message = "ccExpiration is required")
    @NotBlank(message = "ccExpiration is required")
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Must be formatted MM/YY")
    @Column(name = "cc_expiration", nullable = false)
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    @Column(name = "cc_cvv", nullable = false)
    private String ccCVV;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "team_reg_id", nullable = false)
    private Team team;

}
