package br.com.carv.msclient.service;

import br.com.carv.msclient.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client save(Client client);

    Client update(Client client);

    void delete(Long id);

    Client findById(Long id);

    List<Client> findAll();

    Optional<Client> findByCertificatePerson(String certificate);

}
