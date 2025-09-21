package org.example.domain.contracts;

import org.example.domain.model.User;

import java.util.Optional;

/**
 * Gateway interface for external User data services.
 */
public interface UserGateway {
    /**
     * Get user information from an external service.
     *
     * @param email the user's email
     * @return an Optional containing the user if found
     */
    Optional<User> getUserByEmail(String email);
    
    /**
     * Verify user credentials with an external service.
     *
     * @param email the user's email
     * @param password the user's password
     * @return true if credentials are valid, false otherwise
     */
    boolean verifyCredentials(String email, String password);
}