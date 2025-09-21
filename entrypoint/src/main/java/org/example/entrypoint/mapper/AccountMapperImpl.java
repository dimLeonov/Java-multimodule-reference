package org.example.entrypoint.mapper;

import org.example.domain.model.Account;
import org.example.entrypoint.dto.AccountDto;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {
    @Override
    public Account toDomain(AccountDto dto) {
        if (dto == null) {
            return null;
        }
        Account account = new Account();
        account.setId(dto.getId());
        account.setAccountNumber(dto.getAccountNumber());
        account.setBalance(dto.getBalance());
        return account;
    }

    @Override
    public AccountDto toDto(Account domain) {
        if (domain == null) {
            return null;
        }
        AccountDto dto = new AccountDto();
        dto.setId(domain.getId());
        dto.setAccountNumber(domain.getAccountNumber());
        dto.setBalance(domain.getBalance());
        return dto;
    }
}

