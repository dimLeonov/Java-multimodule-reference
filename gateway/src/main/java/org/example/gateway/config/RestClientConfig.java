package org.example.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean("frankfurterRestClient")
    public RestClient frankfurterRestClient(
            RestClient.Builder restClientBuilder,
            @Value("${frankfurter.api.base-url}") String baseUrl
    ) {
        return restClientBuilder
                .baseUrl(baseUrl)
                .build();
    }
}

