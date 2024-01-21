package com.example.registeration_service.model;

import jakarta.persistence.*;

/**
 * Date-10/24/2023
 * By Sardor Tokhirov
 * Time-8:41 AM (GMT+5)
 */
@Entity
@Table(name = "country_codes")
public class CountryCode {
    @Id
    @Column(name = "country_code_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_code_sequence")
    @SequenceGenerator(name = "country_code_sequence", sequenceName = "country_code_sequence_name", allocationSize = 1)
    private Integer countryCodeId;

    @Column(name = "country_code", unique = true)
    private Integer countryCode;

    public CountryCode() {
    }

    public CountryCode(Integer countryCodeId) {
        this.countryCodeId = countryCodeId;
    }

    public Integer getCountryCodeId() {
        return countryCodeId;
    }

    public void setCountryCodeId(Integer countryCodeId) {
        this.countryCodeId = countryCodeId;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }
}
