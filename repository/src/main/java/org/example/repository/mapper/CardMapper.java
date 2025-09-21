package org.example.repository.mapper;

import org.example.domain.model.Card;
import org.example.repository.entity.CardEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between Card domain model and CardEntity.
 */
@Component
public class CardMapper {
    
    /**
     * Convert a domain model to a JPA entity.
     *
     * @param card the domain model
     * @return the JPA entity
     */
    public CardEntity toEntity(Card card) {
        if (card == null) {
            return null;
        }
        
        return CardEntity.builder()
                .id(card.getId())
                .accountId(card.getAccountId())
                .cardNumber(card.getCardNumber())
                .cardType(card.getCardType())
                .cardholderName(card.getCardholderName())
                .expirationDate(card.getExpirationDate())
                .cvv(card.getCvv())
                .isActive(card.getIsActive())
                .createdAt(card.getCreatedAt())
                .build();
    }
    
    /**
     * Convert a JPA entity to a domain model.
     *
     * @param entity the JPA entity
     * @return the domain model
     */
    public Card toDomain(CardEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return Card.builder()
                .id(entity.getId())
                .accountId(entity.getAccountId())
                .cardNumber(entity.getCardNumber())
                .cardType(entity.getCardType())
                .cardholderName(entity.getCardholderName())
                .expirationDate(entity.getExpirationDate())
                .cvv(entity.getCvv())
                .isActive(entity.getIsActive())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}