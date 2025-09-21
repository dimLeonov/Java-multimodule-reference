package org.example.repository.jpa;

import org.example.repository.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for card data.
 */
@Repository
public interface CardJpaRepository extends JpaRepository<CardEntity, Long> {
    /**
     * Find card entities by account ID.
     *
     * @param accountId the account ID
     * @return a list of card entities for the account
     */
    List<CardEntity> findByAccountId(Long accountId);
    
    /**
     * Find card entity by card number.
     *
     * @param cardNumber the card number
     * @return an Optional containing the card entity if found
     */
    Optional<CardEntity> findByCardNumber(String cardNumber);
}