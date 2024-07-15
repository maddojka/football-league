package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "team_registration")
public class TeamPayment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "The date of the payment is required")
    @Column(name = "placed_at", nullable = false)
    private LocalDateTime placedAt;

    @NotNull(message = "Payment number is required")
    @NotBlank(message = "Payment number is required")
    @Column(name = "payment_name", nullable = false)
    private String paymentName;

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
