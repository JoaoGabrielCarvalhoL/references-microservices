package br.com.carv.mscreditassessor.model;

import java.math.BigDecimal;

public class EvaluationData {

    private String certificatePerson;
    private Long income;

    public EvaluationData() {

    }

    public EvaluationData(String certificatePerson, Long income) {
        this.certificatePerson = certificatePerson;
        this.income = income;
    }

    public String getCertificatePerson() {
        return certificatePerson;
    }

    public void setCertificatePerson(String certificatePerson) {
        this.certificatePerson = certificatePerson;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }
}
