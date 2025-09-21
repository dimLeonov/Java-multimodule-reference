package org.example.entrypoint.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.domain.model.Card;
import org.example.domain.usecase.cards.GetCardUseCase;
import org.example.domain.usecase.cards.SaveCardUseCase;
import org.example.entrypoint.dto.CardDto;
import org.example.entrypoint.mapper.CardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
@Tag(name = "Cards", description = "the Card API")
public class CardController {

    private static final Logger log = LoggerFactory.getLogger(CardController.class);
    private final GetCardUseCase getCardUseCase;
    private final SaveCardUseCase saveCardUseCase;
    private final CardMapper cardMapper;

    public CardController(GetCardUseCase getCardUseCase, SaveCardUseCase saveCardUseCase, CardMapper cardMapper) {
        this.getCardUseCase = getCardUseCase;
        this.saveCardUseCase = saveCardUseCase;
        this.cardMapper = cardMapper;
    }

    @Operation(summary = "Get a card by its id",
            parameters = {
                    @Parameter(name = "id", description = "ID of the card to be obtained", required = true, in = ParameterIn.PATH)
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the card"),
            @ApiResponse(responseCode = "404", description = "Card not found")
    })
    @GetMapping("/{id}")
    public CardDto getCardById(@PathVariable String id) {
        log.info("Getting card by id: {}", id);
        return cardMapper.toDto(getCardUseCase.execute(Long.parseLong(id)));
    }

    @Operation(summary = "Create a new card")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Card created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public CardDto saveCard(@RequestBody CardDto cardDto) {
        log.info("Saving card: {}", cardDto);
        Card card = cardMapper.toDomain(cardDto);
        return cardMapper.toDto(saveCardUseCase.execute(card));
    }
}
