package org.example.domain.usecase.accounts;

import jakarta.inject.Named;
import org.example.domain.contracts.AccountRepository;
import org.example.domain.model.Account;


/**
 * Use case for retrieving account data.
 */
@Named
public class GetAccountUseCase {
    private final AccountRepository accountRepository;

    public GetAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Get account by ID from the database.
     *
     * @param id the account ID
     * @return an Optional containing the account if found
     */
    public Account execute(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
}