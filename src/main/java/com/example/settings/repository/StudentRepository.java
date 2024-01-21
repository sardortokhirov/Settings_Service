package com.example.registeration_service.repository;

import com.example.registeration_service.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Date-10/24/2023
 * By Sardor Tokhirov
 * Time-12:26 PM (GMT+5)
 */
public interface StudentRepository extends JpaRepository<Student, UUID> {
}
