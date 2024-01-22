package com.example.settings.model.payload;

import com.example.settings.model.Gender;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Date-1/22/2024
 * By Sardor Tokhirov
 * Time-11:29 AM (GMT+5)
 */

@RequiredArgsConstructor
@Getter
@Setter
public class StudentProfilePayload {

    private UUID studentId;

    private String firstName;

    private String lastName;

    private Gender gender;

    private String profilePictureUrl;

    private String userName;

    private LocalDate dateOfBirth;


}
