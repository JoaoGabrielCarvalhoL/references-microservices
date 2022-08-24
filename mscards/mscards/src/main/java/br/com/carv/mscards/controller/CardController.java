package br.com.carv.mscards.controller;

import br.com.carv.mscards.model.Card;
import br.com.carv.mscards.model.ClientCard;
import br.com.carv.mscards.model.dto.CardDto;
import br.com.carv.mscards.model.dto.ClientCardDto;
import br.com.carv.mscards.service.CardService;
import br.com.carv.mscards.service.ClientCardService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cards")
public class CardController {

    private final CardService cardService;

    private final ModelMapper modelMapper;

    private final ClientCardService clientCardService;

    public CardController(CardService cardService, ModelMapper modelMapper, ClientCardService clientCardService) {
        this.cardService = cardService;
        this.modelMapper = modelMapper;
        this.clientCardService = clientCardService;
    }

    @PostMapping
    public ResponseEntity register(@RequestBody CardDto cardDto) {
        Card card = modelMapper.map(cardDto, Card.class);
        cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardByIncome(@RequestParam("income") Long income) {
        List<Card> result = cardService.getCardIncomeLesserEqual(income);
        return ResponseEntity.ok(result);
    }

    @GetMapping(params = "certificate")
    public ResponseEntity<List<ClientCardDto>> getCardByClient(@RequestParam("certificate") String certificate) {
        List<ClientCard> result = clientCardService.listCardByCertificatePerson(certificate);
        List<ClientCardDto> resultList = result.stream().map(ClientCardDto::fromModel).collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }

}
