package org.example.domain.usecase.cards;

import org.example.domain.contracts.CardRepository;
import org.example.domain.model.Card;

import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Use case for retrieving card data.
 */
@Named
public class GetCardUseCase {

    private final CardRepository cardRepository;

    @Inject
    public GetCardUseCase(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    /**
     * Get card by ID from the database.
     *
     * @param id the card ID
     * @return the card if found, null otherwise
     */
    public Card execute(Long id) {
        return cardRepository
                .findById(id)
                .orElse(null);
    }
}