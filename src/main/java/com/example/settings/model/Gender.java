package com.example.registeration_service.model;

import jakarta.persistence.*;

/**
 * Date-10/24/2023
 * By Sardor Tokhirov
 * Time-8:46 AM (GMT+5)
 */
@Entity
@Table(name = "genders")
public class Gender {
    @Id
    @Column(name = "gender_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_sequence")
    @SequenceGenerator(name = "gender_sequence", sequenceName = "gender_sequence_name", allocationSize = 1)
    private Integer genderId;

    @Column(name = "gender_name", unique = true)
    private String genderName;

    public Gender() {
    }

    public Gender(String genderName) {
        this.genderName = genderName;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }
}
