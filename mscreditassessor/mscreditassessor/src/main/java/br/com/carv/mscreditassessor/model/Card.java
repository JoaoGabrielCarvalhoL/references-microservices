package br.com.carv.mscreditassessor.model;

import java.math.BigDecimal;

public class Card {

    private Long id;
    private String name;
    private String flag;
    private BigDecimal limitBasic;

    public Card() {

    }

    public Card(Long id, String name, String flag, BigDecimal limitBasic) {
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.limitBasic = limitBasic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public BigDecimal getLimitBasic() {
        return limitBasic;
    }

    public void setLimitBasic(BigDecimal limitBasic) {
        this.limitBasic = limitBasic;
    }
}
