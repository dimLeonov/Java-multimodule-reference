package org.example.gateway;

import org.example.domain.contracts.UserGateway;
import org.example.domain.model.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

/**
 * Implementation of the UserGateway interface.
 * This is a mock implementation that returns hardcoded user data.
 * In a real application, this would call an external user API.
 */
@Service
public class UserGatewayImpl implements UserGateway {
    
    @Override
    public Optional<User> getUserByEmail(String email) {
        // In a real implementation, this would call an external API
        // For simplicity, we're returning mock data
        if (email == null || email.isEmpty()) {
            return Optional.empty();
        }
        
        // Create a mock user object
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email(email)
                .phoneNumber("+1234567890")
                .address("123 Main St, City, Country")
                .createdAt(Instant.now().getEpochSecond())
                .build();
        
        return Optional.of(user);
    }
    
    @Override
    public boolean verifyCredentials(String email, String password) {
        // In a real implementation, this would call an external API to verify credentials
        // For simplicity, we're returning true for a specific email/password combination
        return email != null && !email.isEmpty() && 
               password != null && !password.isEmpty() && 
               password.equals("password123");
    }
}