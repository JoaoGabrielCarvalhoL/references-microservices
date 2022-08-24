package br.com.carv.mscards.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ClientCard {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String certificatePerson;
    @ManyToOne
    @JoinColumn(name = "id_card")
    private Card card;

    private BigDecimal limit;

    public ClientCard() {

    }

    public ClientCard(String certificatePerson, Card card, BigDecimal limit) {
        this.certificatePerson = certificatePerson;
        this.card = card;
        this.limit = limit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertificatePerson() {
        return certificatePerson;
    }

    public void setCertificatePerson(String certificatePerson) {
        this.certificatePerson = certificatePerson;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
