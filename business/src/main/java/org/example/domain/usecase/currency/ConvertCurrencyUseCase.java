package org.example.domain.usecase.currency;

import jakarta.inject.Named;
import org.example.domain.contracts.GetConversionRate;
import org.example.domain.model.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Named
public class ConvertCurrencyUseCase {
    private final GetConversionRate getConversionRate;

    public ConvertCurrencyUseCase(GetConversionRate getConversionRate) {
        this.getConversionRate = getConversionRate;
    }

    public BigDecimal execute(Currency from, Currency to, BigDecimal amount) {
        if (from == to) {
            return amount;
        }
        BigDecimal rate = getConversionRate.execute(from, to);
        if (rate == null) {
            // Or throw a custom exception
            throw new IllegalArgumentException("Conversion rate not available");
        }
        return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }
}
