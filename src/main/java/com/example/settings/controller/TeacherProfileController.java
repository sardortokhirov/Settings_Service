package com.example.settings.controller;


import com.example.settings.model.payload.StudentProfilePayload;
import com.example.settings.model.payload.TeacherProfilePayload;
import com.example.settings.service.StudentService;
import com.example.settings.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Date-1/27/2024
 * By Sardor Tokhirov
 * Time-10:57 AM (GMT+5)
 */
@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherProfileController {

    private final TeacherService teacherService;


    @GetMapping("/{username}")
    public ResponseEntity<TeacherProfilePayload> getTeacherProfileInfo(@PathVariable String username) {
        return ResponseEntity.ok(teacherService.getTeacherProfile(username));
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherProfilePayload> getTeacherProfileInfoById(@PathVariable UUID teacherId) {
        return ResponseEntity.ok(teacherService.getTeacherProfileById(teacherId));
    }

}
