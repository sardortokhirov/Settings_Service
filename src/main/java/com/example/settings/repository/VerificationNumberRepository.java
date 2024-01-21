package com.example.registeration_service.repository;

import com.example.registeration_service.model.VerificationNumber;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Date-10/26/2023
 * By Sardor Tokhirov
 * Time-3:33 PM (GMT+5)
 */
@Transactional
public interface VerificationNumberRepository extends JpaRepository<VerificationNumber,Long> {

    Optional<VerificationNumber> findByEmail(String email);


    @Modifying
    @Query("DELETE FROM VerificationNumber vn WHERE vn.email = :email")
    void deleteByUser(@Param("email") String email);

}
