package org.example.domain.usecase.accounts;

import jakarta.inject.Named;
import org.example.domain.contracts.AccountRepository;
import org.example.domain.model.Account;

@Named
public class SaveAccountUseCase {
    private final AccountRepository accountRepository;

    public SaveAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Account account) {
        return accountRepository.save(account);
    }
}