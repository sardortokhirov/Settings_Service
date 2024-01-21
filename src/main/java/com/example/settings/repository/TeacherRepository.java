package com.example.registeration_service.repository;

import com.example.registeration_service.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Date-10/24/2023
 * By Sardor Tokhirov
 * Time-12:25 PM (GMT+5)
 */
public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}
