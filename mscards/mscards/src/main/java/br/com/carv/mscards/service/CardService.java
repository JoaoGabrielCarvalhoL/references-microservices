package br.com.carv.mscards.service;

import br.com.carv.mscards.model.Card;

import java.util.List;

public interface CardService {

    public Card save(Card card);

    public List<Card> getCardIncomeLesserEqual(Long income);
}
