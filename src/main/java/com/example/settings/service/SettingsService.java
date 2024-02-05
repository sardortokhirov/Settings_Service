package com.example.settings.service;

import com.example.settings.model.Student;
import com.example.settings.model.Teacher;
import com.example.settings.model.User;
import com.example.settings.model.payload.ProfileEditRequest;
import com.example.settings.repository.StudentRepository;
import com.example.settings.repository.TeacherRepository;
import com.example.settings.repository.UserRepository;
import com.example.settings.role.Role;
import com.example.settings.s3.S3Buckets;
import com.example.settings.s3.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * Date-2/3/2024
 * By Sardor Tokhirov
 * Time-1:50 PM (GMT+5)
 */
@Service
public class SettingsService {
    private final UserRepository userRepository;

    private final TeacherRepository teacherRepository;

    private final StudentRepository studentRepository;
    private final S3Service s3Service;

    private final S3Buckets s3Buckets;

    @Autowired
    public SettingsService(UserRepository userRepository, TeacherRepository teacherRepository, StudentRepository studentRepository, S3Service s3Service, S3Buckets s3Buckets) {
        this.userRepository = userRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.s3Service = s3Service;
        this.s3Buckets = s3Buckets;
    }

    public void uploadUserProfileImage(String username, MultipartFile file) {
        User user = userRepository.findByUserName(username).orElseThrow();
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
        user.setProfilePictureId(randomId);
        userRepository.save(user);
    }

    public byte[] getUserProfileImage(String username, String uuid) {
        if (username == null || uuid == null) return null;

        return s3Service.getObject(
                s3Buckets.getUser(),
                "profile-images/%s/%s".formatted(username, uuid)
        );
    }

    public byte[] getUserProfileImage(String username) {
        String profilePictureId = userRepository.findByUserName(username).orElseThrow().getProfilePictureId();
        return s3Service.getObject(
                s3Buckets.getUser(),
                "profile-images/%s/%s".formatted(username, profilePictureId)
        );
    }

    public void updateUserProfile(String username, ProfileEditRequest request) {
        User user = userRepository.findByUserName(username).orElseThrow();
        if (user.getRole().equals(Role.TEACHER)) {
            Teacher teacher = teacherRepository.findByUser(user);
            teacher.setBio(request.bio());
            teacherRepository.save(teacher);
        }
        if (user.getRole().equals(Role.STUDENT)) {
            Student student = studentRepository.findByUser(user);
            student.setBio(request.bio());
            studentRepository.save(student);
        }

    }
}
