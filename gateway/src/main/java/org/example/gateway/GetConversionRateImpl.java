package org.example.gateway;

import org.example.domain.contracts.GetConversionRate;
import org.example.domain.model.Currency;
import org.example.gateway.dto.FrankfurterResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;

@Component
public class GetConversionRateImpl implements GetConversionRate {

    private static final Logger log = LoggerFactory.getLogger(GetConversionRateImpl.class);
    private final RestClient restClient;

    public GetConversionRateImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public BigDecimal execute(Currency from, Currency to) {
        log.info("Fetching conversion rate for {} to {}", from, to);

        FrankfurterResponse response = restClient
                .get()
                .uri("/latest?from={from}&to={to}", from, to)
                .retrieve()
                .body(FrankfurterResponse.class);

        if (response != null && response.getRates() != null &&
                response.getRates().containsKey(to.name())
        ) {
            final BigDecimal rate = response
                    .getRates()
                    .get(to.name());

            log.info("Conversion rate for {} to {} is {}", from, to, rate);
            return rate;
        }

        log.warn("Could not fetch conversion rate for {} to {}", from, to);
        // Consider a more robust error handling strategy
        return null;
    }
}
