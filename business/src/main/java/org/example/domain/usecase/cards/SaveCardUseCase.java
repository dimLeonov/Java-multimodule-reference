package org.example.domain.usecase.cards;

import org.example.domain.contracts.CardRepository;
import org.example.domain.model.Card;

import jakarta.inject.Named;

@Named
public class SaveCardUseCase {

    private final CardRepository cardRepository;

    public SaveCardUseCase(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card execute(Card card) {
        return cardRepository.save(card);
    }
}