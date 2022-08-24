package br.com.carv.mscreditassessor.model;

import java.math.BigDecimal;

public class ClientCard {

    private String name;

    private String flag;

    private BigDecimal limitAvailable;

    public ClientCard() {

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

    public BigDecimal getLimitAvailable() {
        return limitAvailable;
    }

    public void setLimitAvailable(BigDecimal limitAvailable) {
        this.limitAvailable = limitAvailable;
    }
}
