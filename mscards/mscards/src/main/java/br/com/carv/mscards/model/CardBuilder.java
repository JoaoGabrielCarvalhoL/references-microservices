package br.com.carv.mscards.model;

import java.math.BigDecimal;

public class CardBuilder {

    private Card card;

    public CardBuilder() {
        this.card = new Card();
    }

    public CardBuilder builder() {
        return new CardBuilder();
    }

    public CardBuilder cardName(String cardName) {
        this.card.setCardName(cardName);
        return this;
    }

    public CardBuilder cardFlag(CardFlag cardFlag) {
        this.card.setCardFlag(cardFlag);
        return this;
    }

    public CardBuilder income(BigDecimal income) {
        this.card.setIncome(income);
        return this;
    }

    public CardBuilder limitBasic(BigDecimal limitBasic) {
        this.card.setLimitBasic(limitBasic);
        return this;
    }

    public Card build() {
        return this.card;
    }

}
