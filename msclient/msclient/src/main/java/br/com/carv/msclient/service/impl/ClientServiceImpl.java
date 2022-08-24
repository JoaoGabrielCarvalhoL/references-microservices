package br.com.carv.msclient.service.impl;

import br.com.carv.msclient.domain.Client;
import br.com.carv.msclient.exception.ClientNotFoundException;
import br.com.carv.msclient.repository.ClientRepository;
import br.com.carv.msclient.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
       return save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.delete(findById(id));
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found! Id: " + id));
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findByCertificatePerson(String certificate) {
        return clientRepository.findByCertificatePerson(certificate);
    }
}
