package br.com.carv.mscards.model.dto;

import br.com.carv.mscards.model.CardFlag;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

public class CardDto {

    private Long id;

    private String cardName;

    private CardFlag cardFlag;

    private BigDecimal income;

    private BigDecimal limitBasic;

    public CardDto(Long id, String cardName, CardFlag cardFlag, BigDecimal income, BigDecimal limitBasic) {
        this.id = id;
        this.cardName = cardName;
        this.cardFlag = cardFlag;
        this.income= income;
        this.limitBasic = limitBasic;
    }

    public CardDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public CardFlag getCardFlag() {
        return cardFlag;
    }

    public void setCardFlag(CardFlag cardFlag) {
        this.cardFlag = cardFlag;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getLimitBasic() {
        return limitBasic;
    }

    public void setLimitBasic(BigDecimal limitBasic) {
        this.limitBasic = limitBasic;
    }
}
