package com.example.settings.service;

import com.example.settings.model.Teacher;
import com.example.settings.model.User;
import com.example.settings.model.payload.TeacherProfilePayload;
import com.example.settings.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date-1/27/2024
 * By Sardor Tokhirov
 * Time-11:01 AM (GMT+5)
 */
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    private final SettingsService settingsService;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, SettingsService settingsService) {
        this.teacherRepository = teacherRepository;
        this.settingsService = settingsService;
    }

    public TeacherProfilePayload getTeacherProfile(String userName) {
        Teacher teacher=teacherRepository.findTeacherByUsername(userName);
        User user=teacher.getUser();
        return new TeacherProfilePayload(user.getFirstName(),user.getLastName(),user.getGender(),settingsService.getUserProfileImage(userName, user.getProfilePictureId()),user.getUserName(),user.getDateOfBirth(),teacher.getBio());

    }
}
