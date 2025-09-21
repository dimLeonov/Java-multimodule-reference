package org.example.domain.contracts;

import org.example.domain.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for User data.
 */
public interface UserRepository {
    /**
     * Save a user record.
     *
     * @param user the user data to save
     * @return the saved user data with ID
     */
    User save(User user);

    /**
     * Find a user record by ID.
     *
     * @param id the ID of the user record
     * @return an Optional containing the user record if found
     */
    Optional<User> findById(Long id);

    /**
     * Find user records by email.
     *
     * @param email the email address
     * @return an Optional containing the user record if found
     */
    Optional<User> findByEmail(String email);

    /**
     * Find all user records.
     *
     * @return a list of all user records
     */
    List<User> findAll();

    /**
     * Delete a user record by ID.
     *
     * @param id the ID of the user record to delete
     */
    void deleteById(Long id);
}