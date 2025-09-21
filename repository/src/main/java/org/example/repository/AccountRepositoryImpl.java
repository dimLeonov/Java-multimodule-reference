package org.example.repository;

import org.example.domain.contracts.AccountRepository;
import org.example.domain.model.Account;
import org.example.repository.entity.AccountEntity;
import org.example.repository.jpa.AccountJpaRepository;
import org.example.repository.mapper.AccountMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the AccountRepository interface using JPA.
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {
    
    private final AccountJpaRepository accountJpaRepository;
    private final AccountMapper accountMapper;
    
    public AccountRepositoryImpl(AccountJpaRepository accountJpaRepository, AccountMapper accountMapper) {
        this.accountJpaRepository = accountJpaRepository;
        this.accountMapper = accountMapper;
    }
    
    @Override
    public Account save(Account account) {
        AccountEntity entity = accountMapper.toEntity(account);
        AccountEntity savedEntity = accountJpaRepository.save(entity);
        return accountMapper.toDomain(savedEntity);
    }
    
    @Override
    public Optional<Account> findById(Long id) {
        return accountJpaRepository
                .findById(id)
                .map(accountMapper::toDomain);
    }
    
    @Override
    public List<Account> findByUserId(Long userId) {
        return accountJpaRepository
                .findByUserId(userId)
                .stream()
                .map(accountMapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return accountJpaRepository
                .findByAccountNumber(accountNumber)
                .map(accountMapper::toDomain);
    }
    
    @Override
    public List<Account> findAll() {
        return accountJpaRepository
                .findAll()
                .stream()
                .map(accountMapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public void deleteById(Long id) {
        accountJpaRepository.deleteById(id);
    }
}