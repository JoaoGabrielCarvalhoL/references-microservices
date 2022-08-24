package br.com.carv.mscards.service;

import br.com.carv.mscards.model.ClientCard;

import java.util.List;

public interface ClientCardService {

    List<ClientCard> listCardByCertificatePerson(String certificatePerson);
}
