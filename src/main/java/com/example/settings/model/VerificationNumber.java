package com.example.settings.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Date-21/01/2024
 * By Sardor Tokhirov
 */

@Entity
@Table(name = "verification_numbers")
public class VerificationNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "random_number")
    private Integer randomNumber;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "attempts")
    private Integer attempts = 0;

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public VerificationNumber() {
    }

    public VerificationNumber(String email, Integer randomNumber, LocalDateTime expirationDate) {
        this.email = email;
        this.randomNumber = randomNumber;
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }
}
