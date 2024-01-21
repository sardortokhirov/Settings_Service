package com.example.settings.model;

import jakarta.persistence.*;

import java.util.UUID;

/**
 * Date-21/01/2024
 * By Sardor Tokhirov
 */
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "teacherId", columnDefinition = "uuid")
    private UUID teacherId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Teacher() {
    }

    public Teacher(User user) {
        this.user = user;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
