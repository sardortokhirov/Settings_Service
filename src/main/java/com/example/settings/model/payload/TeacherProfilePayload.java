package com.example.settings.model.payload;

import com.example.settings.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Date-1/27/2024
 * By Sardor Tokhirov
 * Time-11:00 AM (GMT+5)
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TeacherProfilePayload {


    private String firstName;

    private String lastName;

    private Gender gender;

    private String profilePictureUrl;

    private String userName;

    private LocalDate dateOfBirth;

    private String bio;


}
