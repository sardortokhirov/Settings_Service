package com.example.settings.repository;

import com.example.settings.model.VerificationNumber;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Date-21/01/2024
 * By Sardor Tokhirov
 */

@Transactional
public interface VerificationNumberRepository extends JpaRepository<VerificationNumber,Long> {

    Optional<VerificationNumber> findByEmail(String email);


    @Modifying
    @Query("DELETE FROM VerificationNumber vn WHERE vn.email = :email")
    void deleteByUser(@Param("email") String email);

}
