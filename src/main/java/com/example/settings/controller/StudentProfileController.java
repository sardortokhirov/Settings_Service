package com.example.settings.controller;

import com.example.settings.model.payload.StudentProfilePayload;
import com.example.settings.service.SettingsService;
import com.example.settings.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Date-1/22/2024
 * By Sardor Tokhirov
 * Time-6:19 AM (GMT+5)
 */
@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentProfileController {

    private final StudentService studentService;

    private final SettingsService settingsService;

    @GetMapping("/{username}")
    public ResponseEntity<StudentProfilePayload> getStudentProfileInfo(@PathVariable String username) {
        return ResponseEntity.ok(studentService.getStudentProfile(username));
    }

    @PostMapping(value = "/{username}/profile-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadStudentProfileImage(@PathVariable String username, @RequestParam MultipartFile file) {
        settingsService.uploadUserProfileImage(username,file);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{username}/profile-image",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getStudentProfileImage(@PathVariable String username) {
        return ResponseEntity.ok(settingsService.getUserProfileImage(username));
    }

}
