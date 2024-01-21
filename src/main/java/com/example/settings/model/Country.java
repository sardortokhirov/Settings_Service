package com.example.registeration_service.model;

import jakarta.persistence.*;

/**
 * Date-10/24/2023
 * By Sardor Tokhirov
 * Time-8:16 AM (GMT+5)
 */
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_sequence")
    @SequenceGenerator(name = "country_sequence", sequenceName = "country_sequence_name", allocationSize = 1)
    private Integer countryId;

    @Column(name = "country_name", unique = true)
    private String countryName;

    public Country() {
    }

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
