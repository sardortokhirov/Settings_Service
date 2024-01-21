package com.example.settings.repository;

import com.example.settings.model.Student;
import com.example.settings.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Date-21/01/2024
 * By Sardor Tokhirov
 */

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}
