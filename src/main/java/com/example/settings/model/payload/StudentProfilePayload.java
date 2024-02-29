package com.example.settings.model.payload;

import com.example.settings.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.UUID;


/**
 * Date-1/22/2024
 * By Sardor Tokhirov
 * Time-11:29 AM (GMT+5)
 */


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class StudentProfilePayload {

    private UUID studentId;
    private String firstName;

    private String lastName;

    private Gender gender;

    private byte[] profilePicture;

    private String userName;

    private LocalDate dateOfBirth;

    private String bio;

}
