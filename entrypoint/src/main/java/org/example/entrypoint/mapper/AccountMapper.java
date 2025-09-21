package org.example.entrypoint.mapper;

import org.example.domain.model.Account;
import org.example.entrypoint.dto.AccountDto;

public interface AccountMapper {
    Account toDomain(AccountDto dto);
    AccountDto toDto(Account domain);
}

