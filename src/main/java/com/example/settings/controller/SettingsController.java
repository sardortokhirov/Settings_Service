package com.example.settings.controller;

import com.example.settings.model.payload.ProfileEditRequest;
import com.example.settings.service.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

/**
 * Date-2/4/2024
 * By Sardor Tokhirov
 * Time-7:53 AM (GMT+5)
 */
@RestController
@RequestMapping("/api/v1/settings")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SettingsController {

    private final SettingsService settingsService;


    @PostMapping(value = "/{username}/profile-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadUserProfileImage(@PathVariable String username, @RequestParam("file") MultipartFile file) {
        settingsService.uploadUserProfileImage(username, file);
    }

    @GetMapping(value = "/{username}/profile-image")
    public ResponseEntity<String> getUserProfileImage(@PathVariable String username) {
        byte[] imageBytes = settingsService.getUserProfileImage(username);
        return ResponseEntity.ok(Base64.getEncoder().encodeToString(imageBytes));
    }

    @PutMapping(value = "/{username}/profile")
    public ResponseEntity updateProfile(@PathVariable String username,@RequestBody ProfileEditRequest  request) {
        settingsService.updateUserProfile(username,request);
        return ResponseEntity.ok().build();
    }
}
