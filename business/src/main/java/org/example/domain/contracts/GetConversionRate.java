package org.example.domain.contracts;

import org.example.domain.model.Currency;

import java.math.BigDecimal;

public interface GetConversionRate {
    BigDecimal execute(Currency from, Currency to);
}

