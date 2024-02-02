package com.example.settings.service;

import com.example.settings.model.Student;
import com.example.settings.model.User;
import com.example.settings.model.payload.StudentProfilePayload;
import com.example.settings.repository.StudentRepository;
import com.example.settings.s3.S3Buckets;
import com.example.settings.s3.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * Date-1/27/2024
 * By Sardor Tokhirov
 * Time-8:42 AM (GMT+5)
 */
@Service
public class StudentService {


    private final S3Service s3Service;

    private final S3Buckets s3Buckets;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(S3Service s3Service, S3Buckets s3Buckets, StudentRepository studentRepository) {
        this.s3Service = s3Service;
        this.s3Buckets = s3Buckets;
        this.studentRepository = studentRepository;
    }


    public StudentProfilePayload getStudentProfile(String userName) {
        Student student = studentRepository.findStudentByUsername(userName).orElseThrow();
        User user = student.getUser();
        return new StudentProfilePayload(user.getFirstName(), user.getLastName(), user.getGender(), user.getProfilePictureUrl(), user.getUserName(), user.getDateOfBirth(), student.getBio());
    }

    public void uploadStudentProfileImage(String username, MultipartFile file) {
        Student student = studentRepository.findStudentByUsername(username).orElseThrow();
        String randomId = UUID.randomUUID().toString();
        try {
            s3Service.putObject(
                    s3Buckets.getUser(),
                    "profile-images/%s/%s".formatted(username, randomId),
                    file.getBytes()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        student.getUser().setProfilePictureUrl(randomId);
        studentRepository.save(student);
    }

    public byte[] getStudentProfileImage(String username) {
        String profilePictureUrl = studentRepository.findStudentByUsername(username).orElseThrow().getUser().getProfilePictureUrl();
        return s3Service.getObject(
                s3Buckets.getUser(),
                "profile-images/%s/%s".formatted(username, profilePictureUrl)
        );
    }
}
