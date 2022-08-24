package br.com.carv.mscards.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String cardName;

    @Enumerated(EnumType.STRING)
    private CardFlag cardFlag;

    private BigDecimal income;

    private BigDecimal limitBasic;


    public Card() {

    }

    public Card(String cardName, CardFlag cardFlag, BigDecimal income, BigDecimal limitBasic) {
        this.cardName = cardName;
        this.cardFlag = cardFlag;
        this.income = income;
        this.limitBasic = limitBasic;
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
