package br.com.carv.mscreditassessor.model;

import java.util.List;

public class CustomerSituation {

    private ClientData client;

    private List<ClientCard> cards;

    public CustomerSituation() {

    }

    public ClientData getClient() {
        return client;
    }

    public void setClient(ClientData client) {
        this.client = client;
    }

    public List<ClientCard> getCards() {
        return cards;
    }

    public void setCards(List<ClientCard> cards) {
        this.cards = cards;
    }
}
