package br.com.carv.mscards.infra.mqueue;

import br.com.carv.mscards.model.Card;
import br.com.carv.mscards.model.ClientCard;
import br.com.carv.mscards.model.DadosSolicitacaoEmissaoCartao;
import br.com.carv.mscards.repository.CardRepository;
import br.com.carv.mscards.repository.ClientCardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartaoSubscriber {

    private final CardRepository cardRepository;

    private final ClientCardRepository clientCardRepository;

    public EmissaoCartaoSubscriber(CardRepository cardRepository, ClientCardRepository clientCardRepository) {
        this.cardRepository = cardRepository;
        this.clientCardRepository = clientCardRepository;
    }

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
            Card card = cardRepository.findById(dados.getIdCard()).orElseThrow( );
            ClientCard clientCard = new ClientCard();
            clientCard.setCard(card);
            clientCard.setCertificatePerson(dados.getCertificatePerson());
            clientCard.setLimit(dados.getLimit());

            clientCardRepository.save(clientCard);

        }catch (Exception exception) {
            exception.printStackTrace();
        }


    }
}
