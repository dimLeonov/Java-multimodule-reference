package org.example.entrypoint.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO for card data")
public class CardDto {

    @Schema(description = "The unique identifier of the card", example = "1")
    private Long id;
    @Schema(description = "The name of the card holder", example = "John Doe")
    private String cardHolderName;
    @Schema(description = "The card number", example = "1234-5678-9012-3456")
    private String cardNumber;
    @Schema(description = "The CVV of the card", example = "123")
    private String cvv;
    @Schema(description = "The expiration date of the card", example = "12/28")
    private String expirationDate;

    public CardDto() {
    }

    public CardDto(Long id, String cardHolderName, String cardNumber, String cvv, String expirationDate) {
        this.id = id;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
