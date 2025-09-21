package org.example.entrypoint.mapper;

import org.example.domain.model.Card;
import org.example.entrypoint.dto.CardDto;

public interface CardMapper {
    Card toDomain(CardDto dto);
    CardDto toDto(Card domain);
}

