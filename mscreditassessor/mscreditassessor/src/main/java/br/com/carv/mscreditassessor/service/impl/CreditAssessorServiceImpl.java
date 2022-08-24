package br.com.carv.mscreditassessor.service.impl;

import br.com.carv.mscreditassessor.exception.ErroSolicitacaoCartao;
import br.com.carv.mscreditassessor.exception.ErrorOnCommunicationMSException;
import br.com.carv.mscreditassessor.exception.ResourceNotFoundException;
import br.com.carv.mscreditassessor.infra.clients.CardResource;
import br.com.carv.mscreditassessor.infra.clients.ClientResource;
import br.com.carv.mscreditassessor.infra.mqueue.SolicitacaoEmissaoCartaoPublisher;
import br.com.carv.mscreditassessor.model.*;
import br.com.carv.mscreditassessor.service.CreditAssessorService;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CreditAssessorServiceImpl implements CreditAssessorService {

    private final ClientResource clientResource;
    private final CardResource cardResource;
    private final SolicitacaoEmissaoCartaoPublisher publisher;

    public CreditAssessorServiceImpl(ClientResource clientResource, CardResource cardResource, SolicitacaoEmissaoCartaoPublisher publisher) {
        this.clientResource = clientResource;
        this.cardResource = cardResource;
        this.publisher = publisher;
    }
    @Override
    public CustomerSituation getSituation(String certificatePerson) throws ResourceNotFoundException, ErrorOnCommunicationMSException  {

        try{
            ResponseEntity<ClientData> response = clientResource.getClient(certificatePerson);
            ResponseEntity<List<ClientCard>> cardResponse = cardResource.getCardByClient(certificatePerson);

            CustomerSituation customer = new CustomerSituation();
            customer.setClient(response.getBody());
            customer.setCards(cardResponse.getBody());
            return customer;
        }catch (FeignException.FeignClientException exception) {
            int statusCode = exception.status();

            if (HttpStatus.NOT_FOUND.value() == statusCode) {
                throw new ResourceNotFoundException("Data of client not found on system");
            }

            throw new ErrorOnCommunicationMSException(exception.getMessage(), statusCode);
        }

    }

    @Override
    public ResponseEvaluationClient makeEvaluation(String certificatePerson, Long income) throws ResourceNotFoundException, ErrorOnCommunicationMSException {
        try {
            ResponseEntity<ClientData> response = clientResource.getClient(certificatePerson);
            ResponseEntity<List<Card>> cards = cardResource.getCardByIncome(income);

            List<Card> cardsToBeApproved = cards.getBody();
            List<ApprovedCard> approvedCards = cardsToBeApproved.stream().map(card -> {

                BigDecimal basicLimit = card.getLimitBasic();
                BigDecimal value = BigDecimal.valueOf(income);
                BigDecimal age = BigDecimal.valueOf(response.getBody().getAge());

                BigDecimal factor = age.divide(BigDecimal.valueOf(10));

                BigDecimal approved = factor.multiply(basicLimit);

                ApprovedCard approvedCard = new ApprovedCard();
                approvedCard.setCardName(card.getName());
                approvedCard.setFlag(card.getFlag());
                approvedCard.setLimit(approved);

                return approvedCard;
            }).collect(Collectors.toList());

            return new ResponseEvaluationClient(approvedCards);
        }catch (FeignException.FeignClientException exception) {
            int statusCode = exception.status();

            if (HttpStatus.NOT_FOUND.value() == statusCode) {
                throw new ResourceNotFoundException("Data of client not found on system");
            }

            throw new ErrorOnCommunicationMSException(exception.getMessage(), statusCode);
        }

    }

    public ProtocoloSolicitacaoCartao solicitarEmissaoCartao(DadosSolicitacaoEmissaoCartao dados) {

        try {
            publisher.solicitarCartao(dados);
            String protocol = UUID.randomUUID().toString();
            return new ProtocoloSolicitacaoCartao(protocol);

        }catch (Exception exception) {
            throw new ErroSolicitacaoCartao(exception.getMessage());
        }
    }
}
