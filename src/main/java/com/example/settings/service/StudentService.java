package com.example.settings.service;

import com.example.settings.model.Student;
import com.example.settings.model.User;
import com.example.settings.model.payload.StudentProfilePayload;
import com.example.settings.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date-1/27/2024
 * By Sardor Tokhirov
 * Time-8:42 AM (GMT+5)
 */
@Service
public class StudentService {


    private final StudentRepository studentRepository;

    private final SettingsService settingsService;

    @Autowired
    public StudentService(StudentRepository studentRepository, SettingsService settingsService) {
        this.studentRepository = studentRepository;
        this.settingsService = settingsService;
    }


    public StudentProfilePayload getStudentProfile(String userName) {
        System.out.println("uuuuuuuuuuuuuuuuuuuuuuuu: "+ userName);
        Student student = studentRepository.findStudentByUsername(userName).orElseThrow();
        User user = student.getUser();
        return new StudentProfilePayload(user.getUserId(),user.getFirstName(), user.getLastName(), user.getGender(), settingsService.getUserProfileImage(userName, user.getProfilePictureId()), user.getUserName(), user.getDateOfBirth(), student.getBio());
    }


}
