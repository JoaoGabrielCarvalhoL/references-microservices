package br.com.carv.mscreditassessor.model;

import java.math.BigDecimal;

public class ApprovedCard {

    private String cardName;

    private String flag;

    private BigDecimal limit;

    public ApprovedCard() {

    }

    public ApprovedCard(String cardName, String flag, BigDecimal limit) {
        this.cardName = cardName;
        this.flag = flag;
        this.limit = limit;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
