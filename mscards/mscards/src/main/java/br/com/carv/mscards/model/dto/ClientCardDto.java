package br.com.carv.mscards.model.dto;

import br.com.carv.mscards.model.ClientCard;

import java.math.BigDecimal;

public class ClientCardDto {

    private String cardName;
    private String cardFlag;
    private BigDecimal limit;

    public ClientCardDto() {

    }

    public ClientCardDto(String cardName, String cardFlag, BigDecimal limit) {
        this.cardName = cardName;
        this.cardFlag = cardFlag;
        this.limit = limit;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardFlag() {
        return cardFlag;
    }

    public void setCardFlag(String cardFlag) {
        this.cardFlag = cardFlag;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public static ClientCardDto fromModel(ClientCard model) {
        return new ClientCardDto(model.getCard().getCardName(), model.getCard().getCardFlag().toString(), model.getLimit());
    }
}
