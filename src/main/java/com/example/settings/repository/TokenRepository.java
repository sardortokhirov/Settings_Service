package com.example.registeration_service.repository;

import com.example.registeration_service.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Date-7/5/2023
 * Time-9:36 AM
 */
public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query("""
            select t from Token t inner join User s on t.user.userId = s.userId where s.userId = :userId and (t.expired =false or t.revoked =false)
            """)
    List<Token> findByValidTokensBySupplier(UUID userId);

    Optional<Token> findByToken(String token);
}
