package org.example.repository.jpa;

import org.example.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA repository for user data.
 */
@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    /**
     * Find user entity by email.
     *
     * @param email the email address
     * @return an Optional containing the user entity if found
     */
    Optional<UserEntity> findByEmail(String email);
}