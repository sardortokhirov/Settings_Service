package com.example.settings.service;

import com.example.settings.model.Student;
import com.example.settings.model.User;
import com.example.settings.model.payload.StudentProfilePayload;
import com.example.settings.repository.StudentRepository;
import com.example.settings.repository.UserRepository;
import com.example.settings.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date-1/27/2024
 * By Sardor Tokhirov
 * Time-8:42 AM (GMT+5)
 */
@Service
public class StudentService {


    private final UserRepository userRepository;


    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(UserRepository userRepository, StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }


    public StudentProfilePayload getStudentProfile(String userName) {
        Student student=studentRepository.findStudentByUsername(userName);
        User user=student.getUser();
        return new StudentProfilePayload(user.getFirstName(),user.getLastName(),user.getGender(),user.getProfilePictureUrl(),user.getUserName(),user.getDateOfBirth(),student.getBio());
    }
}
