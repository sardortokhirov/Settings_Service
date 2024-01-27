package com.example.settings.repository;

import com.example.settings.model.Student;
import com.example.settings.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * Date-21/01/2024
 * By Sardor Tokhirov
 */

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {

    @Query("SELECT s FROM Teacher s WHERE s.user.userName = :username")
    Teacher findTeacherByUsername(@Param("username") String username);
}
