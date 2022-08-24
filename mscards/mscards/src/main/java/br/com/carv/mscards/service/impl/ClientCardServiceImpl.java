package br.com.carv.mscards.service.impl;

import br.com.carv.mscards.model.ClientCard;
import br.com.carv.mscards.repository.ClientCardRepository;
import br.com.carv.mscards.service.ClientCardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCardServiceImpl implements ClientCardService {

    private final ClientCardRepository cardRepository;

    public ClientCardServiceImpl(ClientCardRepository clientCardRepository) {
        this.cardRepository = clientCardRepository;
    }

    public List<ClientCard> listCardByCertificatePerson(String certificatePerson) {
        return cardRepository.findClientCardByCertificatePerson(certificatePerson);
    }
}
