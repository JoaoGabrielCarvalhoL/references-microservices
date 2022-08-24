package br.com.carv.mscreditassessor.model;

import java.util.List;

public class ResponseEvaluationClient {

    private List<ApprovedCard> cards;

    public ResponseEvaluationClient() {

    }

    public ResponseEvaluationClient(List<ApprovedCard> cards) {
        this.cards = cards;
    }

    public List<ApprovedCard> getCards() {
        return cards;
    }

    public void setCards(List<ApprovedCard> cards) {
        this.cards = cards;
    }
}
