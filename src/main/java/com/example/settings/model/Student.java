package com.example.registeration_service.model;

import jakarta.persistence.*;

import java.util.UUID;

/**
 * Date-10/24/2023
 * By Sardor Tokhirov
 * Time-12:05 PM (GMT+5)
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "teacherId", columnDefinition = "uuid")
    private UUID teacherId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Student(User user) {
        this.user = user;
    }

    public Student() {
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
