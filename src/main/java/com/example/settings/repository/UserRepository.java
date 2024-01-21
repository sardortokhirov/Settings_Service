package com.example.registeration_service.repository;

import com.example.registeration_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Date-10/24/2023
 * By Sardor Tokhirov
 * Time-12:23 PM (GMT+5)
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String username);
}
