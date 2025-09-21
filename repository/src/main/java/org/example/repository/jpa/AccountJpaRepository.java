package org.example.repository.jpa;

import org.example.repository.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for account data.
 */
@Repository
public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {
    /**
     * Find account entities by user ID.
     *
     * @param userId the user ID
     * @return a list of account entities for the user
     */
    List<AccountEntity> findByUserId(Long userId);
    
    /**
     * Find account entity by account number.
     *
     * @param accountNumber the account number
     * @return an Optional containing the account entity if found
     */
    Optional<AccountEntity> findByAccountNumber(String accountNumber);
}