package org.example.entrypoint.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.domain.model.Account;
import org.example.domain.usecase.accounts.GetAccountUseCase;
import org.example.domain.usecase.accounts.SaveAccountUseCase;
import org.example.entrypoint.dto.AccountDto;
import org.example.entrypoint.mapper.AccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Accounts", description = "the Account API")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final GetAccountUseCase getAccountUseCase;
    private final SaveAccountUseCase saveAccountUseCase;
    private final AccountMapper accountMapper;

    public AccountController(GetAccountUseCase getAccountUseCase, SaveAccountUseCase saveAccountUseCase, AccountMapper accountMapper) {
        this.getAccountUseCase = getAccountUseCase;
        this.saveAccountUseCase = saveAccountUseCase;
        this.accountMapper = accountMapper;
    }

    @Operation(summary = "Get an account by its id",
            parameters = {
                    @Parameter(name = "id", description = "ID of the account to be obtained", required = true, in = ParameterIn.PATH)
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the account"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @GetMapping("/{id}")
    public AccountDto getAccountById(@PathVariable String id) {
        log.info("Getting account by id: {}", id);
        return accountMapper.toDto(getAccountUseCase.execute(Long.parseLong(id)));
    }

    @Operation(summary = "Create a new account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public AccountDto saveAccount(@RequestBody AccountDto accountDto) {
        log.info("Saving account: {}", accountDto);
        Account account = accountMapper.toDomain(accountDto);
        return accountMapper.toDto(saveAccountUseCase.execute(account));
    }
}
