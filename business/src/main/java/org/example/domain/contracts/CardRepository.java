package org.example.domain.contracts;

import org.example.domain.model.Card;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Card data.
 */
public interface CardRepository {
    /**
     * Save a card record.
     *
     * @param card the card data to save
     * @return the saved card data with ID
     */
    Card save(Card card);

    /**
     * Find a card record by ID.
     *
     * @param id the ID of the card record
     * @return an Optional containing the card record if found
     */
    Optional<Card> findById(Long id);

    /**
     * Find card records by account ID.
     *
     * @param accountId the account ID
     * @return a list of card records for the account
     */
    List<Card> findByAccountId(Long accountId);

    /**
     * Find a card record by card number.
     *
     * @param cardNumber the card number
     * @return an Optional containing the card record if found
     */
    Optional<Card> findByCardNumber(String cardNumber);

    /**
     * Find all card records.
     *
     * @return a list of all card records
     */
    List<Card> findAll();

    /**
     * Delete a card record by ID.
     *
     * @param id the ID of the card record to delete
     */
    void deleteById(Long id);
}