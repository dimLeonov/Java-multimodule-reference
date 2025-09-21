package org.example.entrypoint.controller;

import org.example.domain.model.Currency;
import org.example.domain.usecase.currency.ConvertCurrencyUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyConversionControllerTest {

    @Mock
    private ConvertCurrencyUseCase convertCurrencyUseCase;

    @InjectMocks
    private CurrencyConversionController currencyConversionController;

    @Test
    void whenConvertCurrency_thenUseCaseIsCalled() {
        // Given
        Currency from = Currency.USD;
        Currency to = Currency.EUR;
        BigDecimal amount = new BigDecimal("100");
        BigDecimal expectedConversion = new BigDecimal("85.21");

        when(convertCurrencyUseCase.execute(from, to, amount)).thenReturn(expectedConversion);

        // When
        BigDecimal actualConversion = currencyConversionController.convertCurrency(from, to, amount);

        // Then
        verify(convertCurrencyUseCase).execute(from, to, amount);
        assertEquals(expectedConversion, actualConversion);
    }
}

