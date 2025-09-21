package org.example.entrypoint.mapper;

import org.example.domain.model.Card;
import org.example.entrypoint.dto.CardDto;
import org.springframework.stereotype.Component;

@Component
public class CardMapperImpl implements CardMapper {
    @Override
    public Card toDomain(CardDto dto) {
        if (dto == null) {
            return null;
        }
        Card card = new Card();
        card.setId(dto.getId());
        card.setCardholderName(dto.getCardHolderName());
        card.setCardNumber(dto.getCardNumber());
        card.setCvv(dto.getCvv());
        card.setExpirationDate(dto.getExpirationDate());
        return card;
    }

    @Override
    public CardDto toDto(Card domain) {
        if (domain == null) {
            return null;
        }
        CardDto dto = new CardDto();
        dto.setId(domain.getId());
        dto.setCardHolderName(domain.getCardholderName());
        dto.setCardNumber(domain.getCardNumber());
        dto.setCvv(domain.getCvv());
        dto.setExpirationDate(domain.getExpirationDate());
        return dto;
    }
}
