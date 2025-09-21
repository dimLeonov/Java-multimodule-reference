package org.example.repository;

import org.example.domain.contracts.CardRepository;
import org.example.domain.model.Card;
import org.example.repository.entity.CardEntity;
import org.example.repository.jpa.CardJpaRepository;
import org.example.repository.mapper.CardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the CardRepository interface using JPA.
 */
@Repository
public class CardRepositoryImpl implements CardRepository {

    private static final Logger log = LoggerFactory.getLogger(CardRepositoryImpl.class);
    private final CardJpaRepository cardJpaRepository;
    private final CardMapper cardMapper;

    public CardRepositoryImpl(CardJpaRepository cardJpaRepository, CardMapper cardMapper) {
        this.cardJpaRepository = cardJpaRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public Card save(Card card) {
        log.info("Saving card: {}", card);
        CardEntity entity = cardMapper.toEntity(card);
        CardEntity savedEntity = cardJpaRepository.save(entity);
        return cardMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Card> findById(Long id) {
        log.info("Finding card by id: {}", id);
        return cardJpaRepository.findById(id)
                .map(cardMapper::toDomain);
    }

    @Override
    public List<Card> findByAccountId(Long accountId) {
        return cardJpaRepository.findByAccountId(accountId).stream()
                .map(cardMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Card> findByCardNumber(String cardNumber) {
        return cardJpaRepository.findByCardNumber(cardNumber)
                .map(cardMapper::toDomain);
    }

    @Override
    public List<Card> findAll() {
        return cardJpaRepository.findAll().stream()
                .map(cardMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        cardJpaRepository.deleteById(id);
    }
}