package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main Spring Boot application class.
 */
@SpringBootApplication(scanBasePackages = {"org.example"})
@EnableJpaRepositories(basePackages = {"org.example.repository.jpa"})
@EntityScan(basePackages = {"org.example.repository.entity"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}