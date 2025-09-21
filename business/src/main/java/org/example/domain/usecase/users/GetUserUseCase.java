package org.example.domain.usecase.users;

import jakarta.inject.Named;
import org.example.domain.contracts.UserRepository;
import org.example.domain.model.User;

/**
 * Use case for retrieving user data.
 */
@Named
public class GetUserUseCase {
    private final UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Get user by ID from the database.
     *
     * @param id the user ID
     * @return the user if found, null otherwise
     */
    public User execute(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}