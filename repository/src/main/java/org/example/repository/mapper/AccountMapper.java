package org.example.repository.mapper;

import org.example.domain.model.Account;
import org.example.repository.entity.AccountEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between Account domain model and AccountEntity.
 */
@Component
public class AccountMapper {
    
    /**
     * Convert a domain model to a JPA entity.
     *
     * @param account the domain model
     * @return the JPA entity
     */
    public AccountEntity toEntity(Account account) {
        if (account == null) {
            return null;
        }
        
        return AccountEntity.builder()
                .id(account.getId())
                .userId(account.getUserId())
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .isActive(account.getIsActive())
                .createdAt(account.getCreatedAt())
                .build();
    }
    
    /**
     * Convert a JPA entity to a domain model.
     *
     * @param entity the JPA entity
     * @return the domain model
     */
    public Account toDomain(AccountEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return Account.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .accountNumber(entity.getAccountNumber())
                .accountType(entity.getAccountType())
                .balance(entity.getBalance())
                .currency(entity.getCurrency())
                .isActive(entity.getIsActive())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}