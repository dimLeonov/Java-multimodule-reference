package org.example.entrypoint.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.domain.model.Currency;
import org.example.domain.usecase.currency.ConvertCurrencyUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency")
@Tag(name = "Currency Conversion", description = "API for currency conversion")
public class CurrencyConversionController {

    private static final Logger log = LoggerFactory.getLogger(CurrencyConversionController.class);
    private final ConvertCurrencyUseCase convertCurrencyUseCase;

    public CurrencyConversionController(ConvertCurrencyUseCase convertCurrencyUseCase) {
        this.convertCurrencyUseCase = convertCurrencyUseCase;
    }

    @Operation(summary = "Convert an amount from one currency to another")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully converted currency"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping("/convert")
    public BigDecimal convertCurrency(
            @Parameter(description = "Currency to convert from. Supported values: USD, EUR, SEK", required = true) @RequestParam Currency from,
            @Parameter(description = "Currency to convert to. Supported values: USD, EUR, SEK", required = true) @RequestParam Currency to,
            @Parameter(description = "Amount to convert", required = true) @RequestParam BigDecimal amount) {
        log.info("Converting {} {} to {}", amount, from, to);
        return convertCurrencyUseCase.execute(from, to, amount);
    }
}
