package com.example.settings.repository;

import com.example.settings.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Date-21/01/2024
 * By Sardor Tokhirov
 */

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String username);
}
