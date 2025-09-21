package org.example.domain.usecase.currency;

import org.example.domain.contracts.GetConversionRate;
import org.example.domain.model.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConvertCurrencyUseCaseTest {

    @Mock
    private GetConversionRate getConversionRate;

    @InjectMocks
    private ConvertCurrencyUseCase convertCurrencyUseCase;

    @Test
    void whenConvertDifferentCurrencies_thenGatewayIsCalled() {
        // Given
        Currency from = Currency.USD;
        Currency to = Currency.EUR;
        BigDecimal amount = new BigDecimal("100");
        BigDecimal rate = new BigDecimal("0.85");
        BigDecimal expectedAmount = new BigDecimal("85.00");

        when(getConversionRate.execute(from, to)).thenReturn(rate);

        // When
        BigDecimal actualAmount = convertCurrencyUseCase.execute(from, to, amount);

        // Then
        verify(getConversionRate).execute(from, to);
        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void whenConvertSameCurrency_thenGatewayIsNotCalled() {
        // Given
        Currency from = Currency.USD;
        Currency to = Currency.USD;
        BigDecimal amount = new BigDecimal("100");

        // When
        BigDecimal actualAmount = convertCurrencyUseCase.execute(from, to, amount);

        // Then
        verify(getConversionRate, never()).execute(any(), any());
        assertEquals(amount, actualAmount);
    }

    @Test
    void whenRateNotAvailable_thenThrowException() {
        // Given
        Currency from = Currency.USD;
        Currency to = Currency.EUR;
        BigDecimal amount = new BigDecimal("100");

        when(getConversionRate.execute(from, to)).thenReturn(null);

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> convertCurrencyUseCase.execute(from, to, amount));
    }

    @Test
    void whenFromCurrencyIsNull_thenThrowException() {
        // Given
        Currency to = Currency.EUR;
        BigDecimal amount = new BigDecimal("100");

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            convertCurrencyUseCase.execute(null, to, amount);
        });
    }

    @Test
    void whenToCurrencyIsNull_thenThrowException() {
        // Given
        Currency from = Currency.USD;
        BigDecimal amount = new BigDecimal("100");

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            convertCurrencyUseCase.execute(from, null, amount);
        });
    }

    @Test
    void whenAmountIsNull_thenThrowException() {
        // Given
        Currency from = Currency.USD;
        Currency to = Currency.EUR;

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            convertCurrencyUseCase.execute(from, to, null);
        });
    }
}
