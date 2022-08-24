package br.com.carv.mscards.service.impl;

import br.com.carv.mscards.model.Card;
import br.com.carv.mscards.repository.CardRepository;
import br.com.carv.mscards.service.CardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Transactional
    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getCardIncomeLesserEqual(Long income) {
        BigDecimal incomeConvert = BigDecimal.valueOf(income);
        return cardRepository.findByIncomeLessThanEqual(incomeConvert);
    }
}
