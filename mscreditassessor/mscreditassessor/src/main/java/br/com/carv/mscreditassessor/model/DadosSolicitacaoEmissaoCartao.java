package br.com.carv.mscreditassessor.model;

import java.math.BigDecimal;

public class DadosSolicitacaoEmissaoCartao {

    private Long idCard;
    private String certificatePerson;
    private String address;
    private BigDecimal limit;

    public DadosSolicitacaoEmissaoCartao() {

    }

    public DadosSolicitacaoEmissaoCartao(Long idCard, String certificatePerson, String address, BigDecimal limit) {
        this.idCard = idCard;
        this.certificatePerson = certificatePerson;
        this.address = address;
        this.limit = limit;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public String getCertificatePerson() {
        return certificatePerson;
    }

    public void setCertificatePerson(String certificatePerson) {
        this.certificatePerson = certificatePerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
