package br.com.carv.msclient.controller;

import br.com.carv.msclient.domain.Client;
import br.com.carv.msclient.domain.dto.ClientDto;
import br.com.carv.msclient.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;
    
    private ModelMapper modelMapper;

    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity save(@RequestBody ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        client = clientService.save(client);
        URI headerLocation = ServletUriComponentsBuilder.fromCurrentContextPath().query("certificatePerson={certificatePerson}").buildAndExpand(client.getCertificatePerson()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping("findByCertificatePerson")
    public ResponseEntity<ClientDto> getClient(@RequestParam("certificatePerson") String certificatePerson) {
        Optional<Client> client = clientService.findByCertificatePerson(certificatePerson);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ClientDto dto = modelMapper.map(client, ClientDto.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ClientDto update(@RequestBody ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        client = clientService.save(client);
        return modelMapper.map(client, ClientDto.class);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        clientService.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClients() {
        return clientService.findAll();
    }
}
